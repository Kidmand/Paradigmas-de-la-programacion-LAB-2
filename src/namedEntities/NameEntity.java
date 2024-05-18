package namedEntities;

import java.util.List;
import java.util.Set;

abstract public class NameEntity {
    private String label;
    private String category;
    private Set<String> topics;

    public NameEntity(String label, String category, List<String> topics) {
        this.label = label;
        // NOTE: Check if the category is valid, if not, set it to "OTHER"
        this.category = namedEntities.utils.Categories.checkCategory(category);

        // NOTE: Check if the topics are valid, if not, set it to add "OTHER".
        // Use a Set to avoid duplicates of "OTHER".
        this.topics = new java.util.HashSet<String>();
        for (String topic : topics) {
            this.topics.add(namedEntities.utils.Topics.checkTopic(topic));
        }
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
        return new java.util.ArrayList<String>(topics);
    }

    public boolean isTopic(String topic) {
        return this.topics.contains(topic);
    }

    public void print() {
        System.out.println("Label: " + label);
        System.out.println("Category: " + category);
        System.out.println("Topics: " + topics);
    }

}