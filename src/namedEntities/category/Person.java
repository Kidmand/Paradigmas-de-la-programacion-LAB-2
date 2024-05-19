package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;
import namedEntities.definitions.Categories;

public class Person extends NameEntity {

    // TODO: Add more attributes if needed.

    public Person(String label, List<String> topics) {
        super(label, Categories.PERSON, topics);
    }
}