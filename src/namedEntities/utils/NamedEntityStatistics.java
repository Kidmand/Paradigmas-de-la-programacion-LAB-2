package namedEntities.utils;

import java.util.List;

import namedEntities.NamedEntityStorage;

public class NamedEntityStatistics {

    private NamedEntityStorage namedEntityStorage;

    public NamedEntityStatistics(NamedEntityStorage namedEntityStorage) {
        this.namedEntityStorage = namedEntityStorage;
    }

    public void printAnalysisCategories() {
        for (String category : namedEntities.utils.Categories.getCategories()) {
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
        for (String topic : namedEntities.utils.Topics.getTopics()) {
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
