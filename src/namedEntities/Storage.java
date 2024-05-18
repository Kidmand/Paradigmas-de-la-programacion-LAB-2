package namedEntities;

import java.util.HashMap;

public abstract class Storage<T> {
    private HashMap<String, T> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public void add(String key, T value) {
        this.storage.put(key, value);
    }

    public T get(String key) {
        return this.storage.get(key);
    }

    public boolean contains(String key) {
        return this.storage.containsKey(key);
    }

    public void remove(String key) {
        this.storage.remove(key);
    }
}
