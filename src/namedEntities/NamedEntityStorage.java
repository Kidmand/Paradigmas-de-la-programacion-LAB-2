package namedEntities;

import java.util.ArrayList;
import java.util.List;

import namedEntities.category.*;
import namedEntities.dictionary.*;

public class NamedEntityStorage extends Storage<NameEntity> {
    DictionaryStorage dictionary;
    Storage<Integer> labelEntityCount;

    public NamedEntityStorage(DictionaryStorage dictionary) {
        labelEntityCount = new Storage<Integer>();

        this.dictionary = dictionary;
    }

    public void addElement(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        String label = dictionary.getLabelFor(word);

        if (label != null && dictionary.containsLabel(label)) {
            DictNameEntity dictEntity = dictionary.getValue(label);

            if (containsLabel(label)) {
                // Update label for count
                labelEntityCount.remplaceValue(label, labelEntityCount.getValue(label) + 1);
            } else {
                // Add new label for count
                labelEntityCount.addElement(label, 1);

                String category = dictEntity.getCategory();

                if (category.equals("PERSON")) {
                    addElement(label, new Person(label, category, dictEntity.getTopics()));
                } else if (category.equals("ORGANIZATION")) {
                    addElement(label, new Organization(label, category, dictEntity.getTopics()));
                } else if (category.equals("LOCATION")) {
                    addElement(label, new Location(label, category, dictEntity.getTopics()));
                } else {
                    addElement(label, new Other(label, category, dictEntity.getTopics()));
                }
            }
        } else {
            // Add new label for this word
            if (containsLabel(word)) {
                // Update label for count
                labelEntityCount.remplaceValue(word, labelEntityCount.getValue(word) + 1);
            } else {
                // Create new entity
                labelEntityCount.addElement(word, 1);
                addElement(word, new Other(word, "OTHER", new ArrayList<String>()));
            }
        }

    }

    public Integer getLabelEntityCount(String label) {
        return labelEntityCount.getValue(label);
    }

    public List<String> getLabelsOfCategory(String category) {
        List<String> labels = new ArrayList<String>();

        for (String label : getAllLabels()) {
            if (getValue(label).isCategory(category)) {
                labels.add(label);
            }
        }

        return labels;
    }

    public List<String> getLabelsOfTopic(String topic) {
        List<String> labels = new ArrayList<String>();

        for (String label : getAllLabels()) {
            if (getValue(label).isTopic(topic)) {
                labels.add(label);
            }
        }

        return labels;
    }

    public void print() {
        System.out.println("Named Entities:");
        System.out.print("[  ");
        for (String label : getAllLabels()) {
            System.out.print("(" + label + " - " + getLabelEntityCount(label) + ")  ");
        }
        System.out.println("]");
    }

}
