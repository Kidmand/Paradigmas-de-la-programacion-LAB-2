import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

import feed.Article;
import feed.FeedParser;
import utils.Config;
import utils.FeedsData;
import utils.JSONParser;
import utils.UserInterface;

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

        run(config, feedsDataArray);
    }

    // TODO: Change the signature of this function if needed
    private static void run(Config config, List<FeedsData> feedsDataArray) {

        if (config.getPrintHelp()) {
            printHelp(feedsDataArray);
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

        if (config.getNamedEntityKey()) {
            // TODO: complete the message with the selected heuristic name
            System.out.println("Computing named entities using ");

            // TODO: compute named entities using the selected heuristic

            // TODO: Print stats
            System.out.println("\nStats: ");

            // Print line
            printLine();

        }
    }

    // TODO: Maybe relocate this function where it makes more sense
    private static void printHelp(List<FeedsData> feedsDataArray) {
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
        // TODO: Print the available heuristics with the following format
        System.out.println("                                       <name>: <description>");
        System.out.println("  -pf, --print-feed:                   Print the fetched feed");
        System.out.println("  -sf, --stats-format <format>:        Print the stats in the specified format");
        System.out.println("                                       Available formats are: ");
        System.out.println("                                       cat: Category-wise stats");
        System.out.println("                                       topic: Topic-wise stats");
    }

    static private void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
