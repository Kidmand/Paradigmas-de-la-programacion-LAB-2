package namedEntities.definitions;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define los tópicos de las entidades nombradas.
 */
public class Topics {

    // Tópicos de las entidades nombradas.
    public static final String POLITICS = "POLITICS";
    public static final String SPORTS = "SPORTS";
    public static final String ECONOMY = "ECONOMY";
    public static final String HEALTH = "HEALTH";
    public static final String TECHNOLOGY = "TECHNOLOGY";
    public static final String CULTURE = "CULTURE";

    // Tópico especial para entidades no clasificadas.
    public static final String OTHER = "OTHER";

    static private List<String> allTopics() {
        List<String> topics = new ArrayList<>();

        topics.add(POLITICS);
        topics.add(SPORTS);
        topics.add(ECONOMY);
        topics.add(HEALTH);
        topics.add(TECHNOLOGY);
        topics.add(CULTURE);
        // NOTE: Add more categories if needed and define them as constants.

        return topics;
    }

    /**
     * Comprueba si un tópico es válido.
     * 
     * @param topic Tópico a comprobar.
     * @return Devuelve el mismo tópico si es válido o "OTHER" en caso contrario.
     */
    static public String checkTopic(String topic) {
        List<String> topics = allTopics();

        if (topics.contains(topic)) {
            return topic;
        } else {
            return OTHER;
        }
    }

    /**
     * Comprueba si un tópico es válido.
     * 
     * @param topic Tópico a comprobar.
     * @return <code>true</code> si el tópico es válido, <code>false</code> en
     *         caso contrario.
     */
    static public boolean isTopic(String topic) {
        List<String> topics = allTopics();
        return topics.contains(topic);
    }

    /**
     * Devuelve todos los tópicos de las entidades nombradas.
     * 
     * @return Lista con todos los tópicos.
     */
    static public List<String> getTopics() {
        List<String> topics = allTopics();
        topics.add(OTHER);
        return topics;
    }

}
