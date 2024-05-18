package namedEntities.dictionary;

import java.util.List;

import namedEntities.NameEntity;

public class NameEntityDict extends NameEntity {
    List<String> keyWords;

    public NameEntityDict(String label, String category, List<String> topics, List<String> keyWords) {
        super(label, category, topics);
        this.keyWords = keyWords;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public boolean isKeyWord(String keyWord) {
        return keyWords.contains(keyWord);
    }
}