package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;
import namedEntities.definitions.Categories;

public class Other extends NameEntity {

    // TODO: Add more attributes if needed.

    public Other(String label) {
        super(label, Categories.OTHER, List.of(Categories.OTHER));
    }
}
