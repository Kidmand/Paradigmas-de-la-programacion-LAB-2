package utils;

/**
 * hola
 */
//:FIXME: Terminar de documentacion 
public class Config {

    private boolean printFeed = false;
    private boolean printHelp = false;
    private String feedKey = null;
    private String namedEntityKey = null;
    private String statsFormatKey = null;

    public Config(boolean printFeed, boolean printHelp, String feedKey, String namedEntityKey,  String statsFormatKey) {
        this.printFeed = printFeed;
        this.printHelp = printHelp;
        this.feedKey = feedKey;
        this.namedEntityKey = namedEntityKey;
        this.statsFormatKey = statsFormatKey;

    }

    public boolean getPrintFeed() {
        return printFeed;
    }

    public boolean getPrintHelp() {
        return printHelp;
    }

    public boolean getFeedKey() {
        return feedKey != null;
    }

    public boolean getNamedEntityKey() {
        return namedEntityKey != null;
    }

    public boolean getStatsFormatKey() {
        return statsFormatKey != null;
    }

    public String getFeedKeyParam() {
        return feedKey;
    }

    public String getNamedEntityKeyParam() {
        return namedEntityKey;
    }

    public String getStatsFormatKeyParam() {
        return statsFormatKey;
    }

    

}
