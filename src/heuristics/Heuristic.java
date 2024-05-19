package heuristics;

import java.util.List;

/**
 * Clase abstracta que representa una heurística.
 */
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

    /**
     * Extrae los candidatos de una cadena de texto según la heurística.
     * 
     * @param text Cadena de texto.
     * @return Lista de candidatos.
     */
    abstract public List<String> extractCandidates(String text);
}
