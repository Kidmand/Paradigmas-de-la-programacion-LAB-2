package NameEntity.NameEntityDict;

import NameEntity.NameEntity;

import java.util.List;

public class NameEntityDict extends NameEntity{
    List<String> keyWords;
    String category;
    List<String> topics;

    public NameEntityDict(String label, List<String> keyWords, String category, List<String> topics) {
        super(label);
        this.keyWords = keyWords;
        this.category = category;
        this.topics = topics;
    }
}