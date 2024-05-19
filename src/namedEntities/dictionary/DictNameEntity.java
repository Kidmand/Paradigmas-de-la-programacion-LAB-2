package namedEntities.dictionary;

import java.util.List;

import namedEntities.NameEntity;

/**
 * Esta clase representa una entidad de nombre que pertenece a una categoría de
 * diccionario.
 */
public class DictNameEntity extends NameEntity {
    List<String> keywords;

    /**
     * Crea una entidad de nombre que pertenece a una categoría de diccionario.
     * 
     * @param label    El nombre de la entidad.
     * @param category La categoría de la entidad.
     * @param topics   Los temas relacionados con la entidad.
     * @param keywords Las palabras clave relacionadas con la entidad.
     */
    public DictNameEntity(String label, String category, List<String> topics, List<String> keywords) {
        super(label, category, topics);
        this.keywords = keywords;
    }

    /**
     * Obtiene las palabras clave relacionadas con la entidad.
     * 
     * @return Lista de palabras clave.
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * Verifica si la palabra clave está exactamente en la lista de palabras clave.
     * 
     * @param keyword Palabra clave a verificar.
     * @return `true` si la palabra clave está en la lista, `false` en caso
     *         contrario.
     */
    public boolean isKeyword(String keyword) {
        return this.keywords.contains(keyword);
    }

    /**
     * Verifica si la palabra clave está en cualquier formato de la lista de
     * palabras clave.
     * 
     * @param keyword Palabra clave a verificar.
     * @return `true` si la palabra clave está en la lista, `false` en caso
     *         contrario.
     */
    public boolean isKeywordAnyFormat(String keyword) {
        keyword = keyword.toLowerCase();
        for (String kw : this.keywords) {
            kw = kw.toLowerCase();
            if (kw.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Keywords: " + keywords);
    }
}