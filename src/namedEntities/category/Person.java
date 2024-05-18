package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;

public class Person extends NameEntity {

    // TODO: Add more attributes if needed.

    public Person(String label, String category, List<String> topics) {
        super(label, category, topics);
    }
}