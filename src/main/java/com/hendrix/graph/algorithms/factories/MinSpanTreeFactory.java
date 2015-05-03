package com.hendrix.graph.algorithms.factories;

import com.hendrix.graph.algorithms.GraphAlgorithm;
import com.hendrix.graph.algorithms.MSTKruskal;
import com.hendrix.graph.algorithms.MSTPrim;
import com.hendrix.graph.graphs.IUndirectedGraph;
import com.hendrix.graph.graphs.UndirectedGraph;
import com.hendrix.graph.types.IVertex;

/**
 * factory for Minimum Spanning Tree/Forest algorithm according to two available<br/>
 * implementations: {@code MstAlgorithm.KRUSKAL, MstAlgorithm.PRIM}
 *
 * @author Tomer Shalev
 */
@SuppressWarnings("UnusedDeclaration")
public class MinSpanTreeFactory {
    public enum MstAlgorithm {
        KRUSKAL, PRIM
    }

    /**
     * factory for Minimum Spanning Tree/Forest algorithm
     *
     * @param graph the input graph
     * @param algorithm the algorithm of choice: {@code MstAlgorithm.KRUSKAL, MstAlgorithm.PRIM}
     * @param startVertex start vertex of the algorithm, applies only for MstAlgorithm.PRIM
     *
     * @return the MST graph algorithm
     */
    @SuppressWarnings("UnusedDeclaration")
    static public GraphAlgorithm<UndirectedGraph, IUndirectedGraph> newMST(IUndirectedGraph graph, MstAlgorithm algorithm, IVertex startVertex) {
        switch (algorithm) {
            case KRUSKAL:
                return new MSTKruskal(graph);
            case PRIM:
                return new MSTPrim(graph).setStartVertex(startVertex);
        }

        return null;
    }
}
