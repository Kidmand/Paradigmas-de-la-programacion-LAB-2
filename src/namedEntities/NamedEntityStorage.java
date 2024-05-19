package namedEntities;

import java.util.ArrayList;
import java.util.List;

import namedEntities.category.*;
import namedEntities.definitions.Categories;
import namedEntities.dictionary.*;

/**
 * Esta clase funciona como un almacenamiento de entidades nombradas que se
 * pueden acceder a través de una etiqueta.
 */
public class NamedEntityStorage extends Storage<NameEntity> {
    private DictionaryStorage dictionary;

    // Almacenamiento de la cantidad de entidades nombradas por etiqueta.
    private Storage<Integer> labelEntityCount;

    /**
     * Constructor de la clase.
     * 
     * @param dictionary Diccionario de entidades nombradas.
     */
    public NamedEntityStorage(DictionaryStorage dictionary) {
        labelEntityCount = new Storage<Integer>();

        this.dictionary = dictionary;
    }

    /**
     * Agrega un elemento al almacenamiento de entidades nombradas.
     * 
     * @param word Palabra a agregar.
     * 
     * @apiNote Si la palabra no se encuentra en el diccionario, se agrega como una
     *          entidad nombrada de tipo `OTHER`. Es decir que su categoría es
     *          `OTHER` y tiene un único tópico `OTHER`.
     */
    public void addElement(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        String label = dictionary.getLabelFor(word);

        if (label != null && dictionary.containsLabel(label)) { // FIXME: REDUNDANCIA: Si label != null ==> dictionary.containsLabel(label). (dejar solo label != null)
            DictNameEntity dictEntity = dictionary.getValue(label);

            if (containsLabel(label)) {
                // Update label for count
                labelEntityCount.remplaceValue(label, labelEntityCount.getValue(label) + 1);
            } else {
                // Add new label for count
                labelEntityCount.addElement(label, 1);

                String category = dictEntity.getCategory();

                // FIXME: Pensar si esta parte se puede generalizar.
                if (category.equals(Categories.PERSON)) {
                    addElement(label, new Person(label, dictEntity.getTopics()));
                } else if (category.equals(Categories.ORGANIZATION)) {
                    addElement(label, new Organization(label, dictEntity.getTopics()));
                } else if (category.equals(Categories.LOCATION)) {
                    addElement(label, new Location(label, dictEntity.getTopics()));
                } else {
                    addElement(label, new Other(label));
                }
            }
        } else {
            // Add new label for this word
            if (containsLabel(word)) { // FIXME: Esta guarda dara siempre false. RAZON: Si label == null ==> no existe label en el diccionario. (si de arregla fixme de getLabelFor())
                // Update label for count
                labelEntityCount.remplaceValue(word, labelEntityCount.getValue(word) + 1);
            } else { // FIXME: Si una entidad nombrada detectada por la heuristica no esta en el diccionario, se debe guardar? nos servira a fines practicos? queremos saber cuantas veces se detecto una entidad nombrada OTHER?
                // Create new entity
                labelEntityCount.addElement(word, 1);
                addElement(word, new Other(word));
            }
        }

    }

    /**
     * Obtiene la cantidad de entidades nombradas por etiqueta.
     * 
     * @param label Etiqueta de la entidad.
     * @return Cantidad de entidades nombradas.
     * 
     * @apiNote Si la etiqueta no existe, se retorna 0.
     */
    public Integer getLabelEntityCount(String label) {
        if (!labelEntityCount.containsLabel(label)) {
            return 0;
        } else {
            return labelEntityCount.getValue(label);
        }
    }

    /**
     * Obtiene las etiquetas de las entidades nombradas de una categoría dada.
     * 
     * @param category Categoría de la entidad.
     * 
     * @return Lista de etiquetas de las entidades nombradas de la categoría dada.
     */
    public List<String> getLabelsOfCategory(String category) {
        List<String> labels = new ArrayList<String>();

        for (String label : getAllLabels()) {
            if (getValue(label).isCategory(category)) {
                labels.add(label);
            }
        }
        return labels;
    }

    /**
     * Obtiene las etiquetas de las entidades nombradas de un tópico dado.
     * 
     * @param topic Tópico de la entidad.
     * 
     * @return Lista de etiquetas de las entidades nombradas del tópico dado.
     */
    public List<String> getLabelsOfTopic(String topic) {
        List<String> labels = new ArrayList<String>();

        for (String label : getAllLabels()) {
            if (getValue(label).isTopic(topic)) {
                labels.add(label);
            }
        }

        return labels;
    }

    /**
     * Imprime las entidades nombradas en el siguiente formato:
     * <code>
     *  Named Entities:
     *       [  (Marta - 2)  (Pepe - 1)  (Sofia - 1)  ]
     * </code>
     * 
     * @apiNote Imprime las etiquetas de las entidades nombradas y la cantidad de
     *          entidades nombradas por etiqueta.
     **/
    public void print() {
        System.out.println("Named Entities:");
        System.out.print("[  ");
        for (String label : getAllLabels()) {
            System.out.print("(" + label + " - " + getLabelEntityCount(label) + ")  ");
        }
        System.out.println("]");
    }

}
