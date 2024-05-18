package namedEntities.category.Organization;

import java.util.List;

import namedEntities.NameEntity;

public class Organization extends NameEntity {

    public Organization(String label, String category, List<String> topics) {
        super(label, category, topics);
    }
}