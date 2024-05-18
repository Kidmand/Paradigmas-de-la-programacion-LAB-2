package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserInterface {

    private HashMap<String, String> optionDict;

    private List<Option> options;

    public UserInterface() {
        options = new ArrayList<Option>();
        options.add(new Option("-h", "--help", 0));
        options.add(new Option("-f", "--feed", 1));
        options.add(new Option("-ne", "--named-entity", 1));
        options.add(new Option("-pf", "--print-feed", 0));
        options.add(new Option("-sf", "--stats-format", 1));

        optionDict = new HashMap<String, String>();
    }

    public Config handleInput(String[] args) {

        for (Integer i = 0; i < args.length; i++) {
            for (Option option : options) {
                if (option.getName().equals(args[i]) || option.getLongName().equals(args[i])) {
                    if (option.getNumValues() == 0) {
                        optionDict.put(option.getName(), null);
                    } else {
                        if (i + 1 < args.length && !isOption(args[i + 1])) {
                            optionDict.put(option.getName(), args[i + 1]);
                            i++;
                        } else {
                            System.out.println("Invalid inputs");
                            System.exit(1);
                        }
                    }
                }
            }
        }

        Boolean printFeed = optionDict.containsKey("-pf");
        Boolean printHelp = optionDict.containsKey("-h");

        String feedKey = optionDict.get("-f");
        String namedEntityKey = optionDict.get("-ne");
        String statsFormatKey = optionDict.get("-sf");

        return new Config(printFeed, printHelp, feedKey, namedEntityKey, statsFormatKey);
    }

    private Boolean isOption(String s) {
        Boolean res = false;
        for (Option option : options) {
            res = res || (option.getName().equals(s) || option.getLongName().equals(s));
        }
        ;
        return res;
    }
}
