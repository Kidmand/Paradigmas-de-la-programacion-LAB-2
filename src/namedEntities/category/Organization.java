package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;
import namedEntities.definitions.Categories;

public class Organization extends NameEntity {

    // TODO: Add more attributes if needed.

    public Organization(String label, List<String> topics) {
        super(label, Categories.ORGANIZATION, topics);
    }
}