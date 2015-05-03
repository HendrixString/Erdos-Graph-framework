package com.hendrix.graph.algorithms.factories;

import com.hendrix.graph.algorithms.AllPairsShortPathResult;
import com.hendrix.graph.algorithms.FloydWarshall;
import com.hendrix.graph.algorithms.Johnson;
import com.hendrix.graph.graphs.IDirectedGraph;

/**
 * a helper factory for all pairs shortest path according to<br/>
 * implementations: {@code APSPAlgorithm.FloydWarshall, APSPAlgorithm.Johnson}
 *
 * @author Tomer Shalev
 */
@SuppressWarnings("UnusedDeclaration")
public class AllPairsShortPathFactory {
    public enum APSPAlgorithm {
        FloydWarshall, Johnson
    }

    /**
     * factory for all pairs shortest path algorithms
     *
     * @param graph             the input graph
     * @param algorithm         the algorithm of choice: {@code APSPAlgorithm.FloydWarshall, APSPAlgorithm.Johnson}
     *
     * @return the algorithm
     */
    @SuppressWarnings("UnusedDeclaration")
    static public AllPairsShortPathResult newAllPairsShortPath(IDirectedGraph graph, APSPAlgorithm algorithm) {
        switch (algorithm) {
            case FloydWarshall:
                return new FloydWarshall(graph).applyAlgorithm();
            case Johnson:
                return new Johnson(graph).applyAlgorithm();
        }

        return null;
    }

}
