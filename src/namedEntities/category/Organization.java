package namedEntities.category;

import java.util.List;

import namedEntities.NameEntity;

public class Organization extends NameEntity {

    // TODO: Add more attributes if needed.

    public Organization(String label, String category, List<String> topics) {
        super(label, category, topics);
    }
}