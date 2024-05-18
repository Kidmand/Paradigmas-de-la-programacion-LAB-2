package namedEntities.utils;

import java.util.ArrayList;
import java.util.List;

public class Topics {

    static private List<String> allTopics() {
        List<String> topics = new ArrayList<>();

        topics.add("POLITICS");
        topics.add("SPORTS");
        topics.add("ECONOMY");
        topics.add("HEALTH");
        topics.add("TECHNOLOGY");
        topics.add("CULTURE");

        return topics;
    }

    static public String checkTopic(String topic) {
        List<String> topics = allTopics();

        if (topics.contains(topic)) {
            return topic;
        } else {
            return "OTHER";
        }
    }

    static public List<String> getTopics() {
        List<String> topics = allTopics();
        topics.add("OTHER");
        return topics;
    }

}
