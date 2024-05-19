package namedEntities.definitions;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que define las categorías de las entidades nombradas.
 */
public class Categories {

    // Categorías de las entidades nombradas.
    public static final String PERSON = "PERSON";
    public static final String ORGANIZATION = "ORGANIZATION";
    public static final String LOCATION = "LOCATION";

    // Categoría especial para entidades no clasificadas.
    public static final String OTHER = "OTHER";

    static private List<String> allCategories() {
        List<String> categories = new ArrayList<>();

        categories.add(PERSON);
        categories.add(ORGANIZATION);
        categories.add(LOCATION);
        // NOTE: Add more categories if needed and define them as constants.

        return categories;
    }

    /**
     * Comprueba si una categoría es válida.
     * 
     * @param category Categoría a comprobar.
     * @return Devuelve la misma categoría si es válida o "OTHER" en caso contrario.
     */
    static public String checkCategory(String category) {
        List<String> categories = allCategories();

        if (categories.contains(category)) {
            return category;
        } else {
            return OTHER;
        }
    }

    /**
     * Comprueba si una categoría es válida.
     * 
     * @param category Categoría a comprobar.
     * @return <code>true</code> si la categoría es válida, <code>false</code> en
     *         caso contrario.
     */
    static public boolean isCategory(String category) {
        List<String> categories = allCategories();
        return categories.contains(category);
    }

    /**
     * Devuelve todas las categorías de las entidades nombradas.
     * 
     * @return Lista con todas las categorías.
     */
    static public List<String> getCategories() {
        List<String> categories = allCategories();
        categories.add(OTHER);
        return categories;
    }

}
