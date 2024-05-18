package namedEntities.dictionary;

import java.util.List;

import namedEntities.Storage;
import utils.JSONParser;

public class DictionaryStorage extends Storage<DictNameEntity> {
    public DictionaryStorage(String jsonFilePath) {
        super();
        try {
            List<DictNameEntity> dictionaryList = JSONParser.parseJsonDictionaryData(jsonFilePath);
            for (DictNameEntity dict : dictionaryList) {
                this.addElement(dict.getLabel(), dict);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLabelFor(String word) {
        for (DictNameEntity dict : getAllValues()) {
            if (dict.isKeywordAnyFormat(word)) {
                return dict.getLabel();
            }
        }
        return null;
    }

    /* If the label is not found, it returns null. */
    public String getCategory(String label) {
        if (containsLabel(label)) {
            return getValue(label).getCategory();
        } else {
            return null;
        }
    }

    /* If the label is not found, it returns null. */
    public List<String> getTopics(String label) {
        if (containsLabel(label)) {
            return getValue(label).getTopics();
        } else {
            return null;
        }
    }

    /* If the label is not found, it returns null. */
    public List<String> getKeywords(String label) {
        if (containsLabel(label)) {
            return getValue(label).getKeywords();
        } else {
            return null;
        }
    }

    public void print() {
        System.out.println("Dictionary Labels:");
        System.out.print("[");
        for (DictNameEntity value : getAllValues()) {
            System.out.print(value.getLabel() + ", ");
        }
        System.out.println("]");

        System.out.println("---------------------------------------------------");
        for (DictNameEntity value : getAllValues()) {
            value.print();
            System.out.println("---------------------------------------------------");
        }
    }

    public void print(String label) {
        if (containsLabel(label)) {
            getValue(label).print();
        } else {
            System.out.println("Label not found.");
        }
    }
}
