package feed;

public class Article {
    private String title = null;
    private String description = null;
    private String pubDate = null;
    private String link = null;

    public Article(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    static private void printValue(String prefix, String value) {
        if (value == "" || value == null) {
            System.out.println(prefix + ": No content.");
        } else {
            System.out.println(prefix + ": " + value);
        }
    }

    public void print() {
        printValue("Title", title);
        printValue("Description", description);
        printValue("Publication Date", pubDate);
        printValue("Link", link);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLink() {
        return link;
    }

}