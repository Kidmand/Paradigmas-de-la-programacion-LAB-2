package namedEntities.dictionary;

import java.util.List;

import namedEntities.NameEntity;

public class DictNameEntity extends NameEntity {
    List<String> keywords;

    public DictNameEntity(String label, String category, List<String> topics, List<String> keywords) {
        super(label, category, topics);
        this.keywords = keywords;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public boolean isKeyword(String keyword) {
        return this.keywords.contains(keyword);
    }

    /* Check if the keyword is in any format of the keyword list. */
    public boolean isKeywordAnyFormat(String keyword) {
        keyword = keyword.toLowerCase();
        for (String kw : this.keywords) {
            kw = kw.toLowerCase();
            if (kw.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        super.print();
        System.out.println("Keywords: " + keywords);
    }
}