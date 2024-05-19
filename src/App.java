import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

import feed.Article;
import feed.FeedParser;

import heuristics.Heuristic;
import heuristics.HeuristicsTools;

import namedEntities.NamedEntityStorage;
import namedEntities.dictionary.DictionaryStorage;

import utils.*;

public class App {

    public static void main(String[] args) {

        List<FeedsData> feedsDataArray = new ArrayList<>();
        try {
            feedsDataArray = JSONParser.parseJsonFeedsData("src/data/feeds.json");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        UserInterface ui = new UserInterface();
        Config config = ui.handleInput(args);

        List<Heuristic> heuristics = HeuristicsTools.getHeuristics();

        run(config, feedsDataArray, heuristics);
    }

    private static void run(Config config, List<FeedsData> feedsDataArray, List<Heuristic> heuristics) {

        if (config.getPrintHelp()) {
            printHelp(feedsDataArray, HeuristicsTools.getHeuristicsInfo(heuristics));
        }

        if (feedsDataArray == null || feedsDataArray.size() == 0) {
            System.out.println("No feeds data found");
            return;
        }

        FeedsData selectedFeedData = null;

        // Check if the feed key is valid and get the selected feed data
        if (config.getFeedKey()) {

            for (FeedsData feedData : feedsDataArray) {
                if (feedData.getLabel().equals(config.getFeedKeyParam())) {
                    selectedFeedData = feedData;
                    break;
                }
            }

            if (selectedFeedData == null) {
                System.out.println("Invalid feed option");
                return;
            }
        }

        // Fetch the feeds
        List<Article> allArticles = new ArrayList<>();
        if (selectedFeedData != null) {
            try {
                String feedData = FeedParser.fetchFeed(selectedFeedData.getUrl());
                if (selectedFeedData.getType().equals("xml")) {
                    allArticles = FeedParser.parseXML(feedData);
                } else {
                    System.out.println("Invalid feed type, not supported yet");
                    return;
                }
            } catch (MalformedInputException e) {
                System.out.println("Error fetching feed, malformed input");
                e.printStackTrace();
                return;
            } catch (IOException e) {
                System.out.println("Error fetching feed, IO exception");
                e.printStackTrace();
                return;
            } catch (Exception e) {
                System.out.println("Error fetching feed, exception");
                e.printStackTrace();
                return;
            }
        }
        if (config.getPrintFeed()) {
            printLine();
            System.out.println("Printing feed(s) ");

            for (Article article : allArticles) {
                article.print();
                printLine();
            }
        }

        // Named entities
        if (config.getNamedEntityKey()) {
            // Message with the selected heuristic name
            System.out.println("Computing named entities using '" + config.getNamedEntityKeyParam() + "' heuristic.");

            // Load dictionary
            DictionaryStorage dictionary = new DictionaryStorage("src/data/dictionary.json");

            // Extract all content in the articles.
            String allData = "";
            for (Article article : allArticles) {
                allData += article.getTitle() + " " + article.getDescription() + " ";
            }

            // Extract candidates for named entities using the selected heuristic
            List<String> candidates = new ArrayList<>();
            boolean checkExistenceHeuristic = false;
            for (Heuristic heuristic : heuristics) {
                if (heuristic.getName().equals(config.getNamedEntityKeyParam())) {
                    candidates = heuristic.extractCandidates(allData);
                    checkExistenceHeuristic = true;
                    break;
                }
            }
            if (!checkExistenceHeuristic) {
                System.out.println("Invalid named entity heuristic option, use -h for help.");
                return;
            }

            // Create named entity storage
            NamedEntityStorage namedEntityStorage = new NamedEntityStorage(dictionary);
            for (String namedEntity : candidates) {
                namedEntityStorage.addElement(namedEntity);
            }

            // Print stats
            if (config.getStatsFormatKey()) {
                System.out.println("\nStats: ");

                Statistics statistics = new Statistics(namedEntityStorage);

                if (config.getStatsFormatKeyParam().equals("cat")) {
                    statistics.printAnalysisCategories();
                } else if (config.getStatsFormatKeyParam().equals("topic")) {
                    statistics.printAnalysisTopics();
                } else {
                    System.out.println("Invalid stats format option, use -h for help.");
                }
            }

            // Print line
            printLine();

        }
    }

    // TODO: Maybe relocate this function where it makes more sense
    private static void printHelp(List<FeedsData> feedsDataArray, List<String> heuristicsInfo) {
        System.out.println("Usage: make run ARGS=\"[OPTION]\"");
        System.out.println("Options:");
        System.out.println("  -h, --help: Show this help message and exit");
        System.out.println("  -f, --feed <feedKey>:                Fetch and process the feed with");
        System.out.println("                                       the specified key");
        System.out.println("                                       Available feed keys are: ");
        for (FeedsData feedData : feedsDataArray) {
            System.out.println("                                       " + feedData.getLabel());
        }
        System.out.println("  -ne, --named-entity <heuristicName>: Use the specified heuristic to extract");
        System.out.println("                                       named entities");
        System.out.println("                                       Available heuristic names are: ");
        System.out.println("                                       <name>: <description>");
        for (String heuristicInfo : heuristicsInfo) {
            System.out.println("                                       " + heuristicInfo);
        }
        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

    // NOTE: Add this because for some versions of Java the previous version of code
    // that did this did not work.
    static private void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
