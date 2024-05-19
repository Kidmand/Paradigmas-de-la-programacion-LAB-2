package heuristics;

import java.util.ArrayList;
import java.util.List;

public class HeuristicsTools {

    /**
     * Obtiene una lista con las heurísticas que están implementadas.
     * 
     * @return Lista de heurísticas.
     */
    public static List<Heuristic> getHeuristics() {
        List<Heuristic> heuristics = new ArrayList<>();
        heuristics.add(new CapitalizedWordHeuristic());
        // TODO: Add more heuristics here.

        return heuristics;
    }

    /**
     * Obtiene una lista con la información de las heurísticas.
     * 
     * @param heuristics Lista de heurísticas.
     * @return Lista con la información de las heurísticas.
     */
    public static List<String> getHeuristicsInfo(List<Heuristic> heuristics) {
        List<String> heuristicsInfo = new ArrayList<>();
        for (Heuristic heuristic : heuristics) {
            heuristicsInfo.add(heuristic.getLongInfo());
        }
        return heuristicsInfo;
    }
}
