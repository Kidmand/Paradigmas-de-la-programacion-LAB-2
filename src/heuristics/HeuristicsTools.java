package heuristics;

import java.util.ArrayList;
import java.util.List;

public class HeuristicsTools {

    public static List<Heuristic> getHeuristics() {
        List<Heuristic> heuristics = new ArrayList<>();
        heuristics.add(new CapitalizedWordHeuristic());
        // TODO: Add more heuristics here.

        return heuristics;
    }

    public static List<String> getHeuristicsInfo(List<Heuristic> heuristics) {
        List<String> heuristicsInfo = new ArrayList<>();
        for (Heuristic heuristic : heuristics) {
            heuristicsInfo.add(heuristic.getLongInfo());
        }
        return heuristicsInfo;
    }
}
