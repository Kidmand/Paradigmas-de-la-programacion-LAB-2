package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;
import namedEntities.definitions.Categories;

public class Location extends NameEntity {

    // TODO: Add more attributes if needed.

    public Location(String label, List<String> topics) {
        super(label, Categories.LOCATION, topics);
    }
}
