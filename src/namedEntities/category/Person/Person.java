package namedEntities.category.Person;

import java.util.List;

import namedEntities.NameEntity;

public class Person extends NameEntity {
    public Person(String label, String category, List<String> topics) {
        super(label, category, topics);
    }
}