package utils;

import java.util.List;

import namedEntities.NamedEntityStorage;

public class Statistics {

    private NamedEntityStorage namedEntityStorage;

    public Statistics(NamedEntityStorage namedEntityStorage) {
        this.namedEntityStorage = namedEntityStorage;
    }

    public void printAnalysisCategories() {
        for (String category : namedEntities.definitions.Categories.getCategories()) {
            List<String> labels = namedEntityStorage.getLabelsOfCategory(category);
            if (labels.size() == 0) {
                continue;
            }
            System.out.println("Category: " + category);
            for (String label : labels) {
                System.out.println("          " + label + " (" + namedEntityStorage.getLabelEntityCount(label) + ")");
            }
        }
    }

    public void printAnalysisTopics() {
        for (String topic : namedEntities.definitions.Topics.getTopics()) {
            List<String> labels = namedEntityStorage.getLabelsOfTopic(topic);
            if (labels.size() == 0) {
                continue;
            }
            System.out.println("Topic: " + topic);
            for (String label : labels) {
                System.out.println("          " + label + " (" + namedEntityStorage.getLabelEntityCount(label) + ")");
            }
        }
    }

}
