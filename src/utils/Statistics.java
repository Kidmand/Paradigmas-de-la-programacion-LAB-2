package utils;

import java.util.List;

import namedEntities.NamedEntityStorage;

/**
 * Esta clase se encarga de imprimir las estadísticas de las entidades
 * nombradas.
 */
public class Statistics {

    private NamedEntityStorage namedEntityStorage;

    /**
     * Constructor de la clase.
     * 
     * @param namedEntityStorage Almacén de entidades nombradas que se van a
     *                           analizar.
     */
    public Statistics(NamedEntityStorage namedEntityStorage) {
        this.namedEntityStorage = namedEntityStorage;
    }

    /**
     * Imprime una estadística relacionada con las categorías de las entidades.
     */
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

    /**
     * Imprime una estadística relacionada con los tópicos de las entidades.
     */
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
