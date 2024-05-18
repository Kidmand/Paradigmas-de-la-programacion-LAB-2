package namedEntities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Storage<T> {
    protected HashMap<String, T> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    // ------------------------------------

    public void addElement(String label, T value) {
        this.storage.put(label, value);
    }

    // ------------------------------------

    public boolean containsLabel(String label) {
        return this.storage.containsKey(label);
    }

    public Set<String> getAllLabels() {
        return this.storage.keySet();
    }

    // ------------------------------------

    /* If the key is not found, it returns `null`. */
    public T getValue(String label) {
        return this.storage.get(label);
    }

    public List<T> getAllValues() {
        return new ArrayList<T>(storage.values());
    }

    // ------------------------------------

    public void remplaceValue(String label, T value) {
        this.storage.replace(label, value);
    }
}
