package namedEntities.utils;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    static private List<String> allCategories() {
        List<String> categories = new ArrayList<>();

        categories.add("PERSON");
        categories.add("ORGANIZATION");
        categories.add("LOCATION");

        return categories;
    }

    static public String checkCategory(String category) {
        List<String> categories = allCategories();

        if (categories.contains(category)) {
            return category;
        } else {
            return "OTHER";
        }
    }

    static public List<String> getCategories() {
        List<String> categories = allCategories();
        categories.add("OTHER");
        return categories;
    }

}
