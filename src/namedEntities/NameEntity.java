package namedEntities;

import java.util.List;
import java.util.Set;

/**
 * Clase abstracta que representa una entidad nombrada.
 */
abstract public class NameEntity {
    private String label;
    private String category;
    private Set<String> topics;

    /**
     * Constructor de la clase.
     * 
     * @param label    Etiqueta de la entidad.
     * @param category Categoría de la entidad.
     * @param topics   Temas asociados a la entidad.
     * 
     * @apiNote La categoría están definidas por la clase `Categories`, en el
     *          caso que no se encuentre en las definidas se le asigna `OTHER`.
     * 
     * @apiNote Los tópicos están definidos por `Topics`, en el caso que no se
     *          encuentre en los definidos se le asigna `OTHER`.
     */
    public NameEntity(String label, String category, List<String> topics) {
        this.label = label;
        // NOTE: Chequea si la categoría es válida, si no, se le asigna "OTHER".
        this.category = namedEntities.definitions.Categories.checkCategory(category);

        // NOTE: Chequea si los tópicos son válidos, si no, se le asigna "OTHER".
        // NOTE: Se crea un nuevo conjunto para evitar, si son varios los topics que no
        // sean válidos, evitando que se repita el topic "OTHER".
        this.topics = new java.util.HashSet<String>();
        for (String topic : topics) {
            this.topics.add(namedEntities.definitions.Topics.checkTopic(topic));
        }
    }

    /**
     * Obtiene la etiqueta de la entidad.
     * 
     * @return Etiqueta de la entidad.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Obtiene la categoría de la entidad.
     * 
     * @return Categoría de la entidad.
     * 
     * @apiNote Las categorías están definidas por la clase `Categories`.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Verifica si la categoría de la entidad es igual a la categoría dada.
     * 
     * @param category Categoría a verificar.
     * @return `true` si la categoría es igual, `false` en caso contrario.
     */
    public boolean isCategory(String category) {
        return this.category.equals(category);
    }

    /**
     * Obtiene los tópicos asociados a la entidad.
     * 
     * @return Lista de tópicos asociados a la entidad.
     * 
     * @apiNote Los tópicos están definidos por la clase `Topics`, no hay otros.
     */
    public List<String> getTopics() {
        return new java.util.ArrayList<String>(topics);
    }

    /**
     * Verifica si la entidad tiene un tópico dado.
     * 
     * @param topic Tópico a verificar.
     * @return `true` si la entidad tiene el tópico, `false` en caso contrario.
     */
    public boolean isTopic(String topic) {
        return this.topics.contains(topic);
    }

    /**
     * Imprime la entidad.
     * 
     * <p>
     * <b>Formato:</b>
     * <p>
     * 
     * <pre>
     *  Label: label
     *  Category: category
     *  Topics: [topic1, topic2, ..., topicN]
     * </pre>
     * 
     * @apiNote Se imprime la etiqueta, la categoría y los tópicos de la entidad.
     *          Se usa para depuración.
     */
    public void print() {
        System.out.println("Label: " + label);
        System.out.println("Category: " + category);
        System.out.println("Topics: " + topics);
    }

}