package heuristics;

import java.util.List;

public abstract class Heuristic {
    private String name;
    private String description;

    public Heuristic(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLongInfo() {
        return name + ": " + description;
    }

    abstract public List<String> extractCandidates(String text);
}
