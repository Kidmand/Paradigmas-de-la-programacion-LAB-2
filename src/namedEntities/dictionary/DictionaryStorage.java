package namedEntities.dictionary;

import java.util.List;

import namedEntities.Storage;
import utils.JSONParser;

/**
 * Esta clase almacena los datos de las entidades de tipo "Diccionario" que se
 * pueden acceder a través de una etiqueta.
 */
public class DictionaryStorage extends Storage<DictNameEntity> {

    /**
     * Constructor de la clase.
     * 
     * @param jsonFilePath Ruta del archivo JSON que contiene los datos de las
     *                     entidades de tipo "Diccionario".
     */
    public DictionaryStorage(String jsonFilePath) {
        super();
        try {
            List<DictNameEntity> dictionaryList = JSONParser.parseJsonDictionaryData(jsonFilePath);
            for (DictNameEntity dict : dictionaryList) {
                this.addElement(dict.getLabel(), dict);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la etiqueta de la entidad que contiene o es la palabra.
     * 
     * @param word Palabra a buscar.
     * @return Etiqueta de la entidad que contiene la palabra.
     * 
     * @apiNote Si la palabra no se encuentra en ninguna entidad, se retorna
     *          <code>null</code>.
     */
    public String getLabelFor(String word) {
        for (DictNameEntity dict : getAllValues()) {
            if (dict.isKeywordAnyFormat(word) || dict.getLabel().equals(word)) {
                return dict.getLabel();
            }
        }
        return null;
    }

    /**
     * Obtiene la categoría de la entidad.
     * 
     * @param label Etiqueta de la entidad.
     * @return Categoría de la entidad.
     * 
     * @apiNote Si la etiqueta no se encuentra, se retorna <code>null</code>.
     */
    public String getCategory(String label) {
        if (containsLabel(label)) {
            return getValue(label).getCategory();
        } else {
            return null;
        }
    }

    /**
     * Obtiene los tópicos de la entidad.
     * 
     * @param label Etiqueta de la entidad.
     * @return Tópicos de la entidad.
     * 
     * @apiNote Si la etiqueta no se encuentra, se retorna <code>null</code>.
     */
    public List<String> getTopics(String label) {
        if (containsLabel(label)) {
            return getValue(label).getTopics();
        } else {
            return null;
        }
    }

    /**
     * Obtiene las palabras clave de la entidad.
     * 
     * @param label Etiqueta de la entidad.
     * @return Palabras clave de la entidad.
     * 
     * @apiNote Si la etiqueta no se encuentra, se retorna <code>null</code>.
     */
    public List<String> getKeywords(String label) {
        if (containsLabel(label)) {
            return getValue(label).getKeywords();
        } else {
            return null;
        }
    }

    /**
     * Imprime las etiquetas de las entidades almacenadas.
     * 
     */
    public void print() {
        System.out.println("Dictionary Labels:");
        System.out.print("[");
        for (DictNameEntity value : getAllValues()) {
            System.out.print(value.getLabel() + ", ");
        }
        System.out.println("]");

        System.out.println("---------------------------------------------------");
        for (DictNameEntity value : getAllValues()) {
            value.print();
            System.out.println("---------------------------------------------------");
        }
    }

    /**
     * Imprime la entidad con la etiqueta dada.
     * 
     * @param label Etiqueta de la entidad.
     */
    public void print(String label) {
        if (containsLabel(label)) {
            getValue(label).print();
        } else {
            System.out.println("Label not found.");
        }
    }
}
