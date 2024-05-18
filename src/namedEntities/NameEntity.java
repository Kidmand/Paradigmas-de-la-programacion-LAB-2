package namedEntities;

import java.util.List;

abstract public class NameEntity {
    String label;
    String category;
    List<String> topics;

    public NameEntity(String label, String category, List<String> topics) {
        this.label = label;
        this.category = category;
        this.topics = topics;
    }

    public String getLabel() {
        return label;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCategory(String category) {
        return this.category.equals(category);
    }

    public List<String> getTopics() {
        return topics;
    }

    public boolean isTopic(String topic) {
        return topics.contains(topic);
    }

}