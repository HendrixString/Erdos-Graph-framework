package com.hendrix.graph.utils;

import com.hendrix.graph.comperators.EdgeWeightComparator;
import com.hendrix.graph.graphs.IGraph;
import com.hendrix.graph.types.Edge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Helper utilities for graph
 *
 * @author Tomer Shalev
 */
public class SGraphUtils
{
    /**
     * common vertices colors for graphs search algorithms
     */
    public enum COLOR {
        WHITE, GREY, BLACK
    }

    /**
     * sort order enum for weighted edges
     * @see #sortWeightedEdgesOf(com.hendrix.graph.graphs.IGraph, com.hendrix.graph.utils.SGraphUtils.EdgeSortOrder)
     */
    public enum EdgeSortOrder {
        NONDECREASING, NONINCREASING
    }

    /**
     * helper method for sorting weighted edges of a graph
     * @param graph the graph
     * @param order {@code EdgeSortOrder.NONDECREASING, EdgeSortOrder.NONINCREASING}
     * @return array list of sorted edges
     */
    static public ArrayList<Edge> sortWeightedEdgesOf(IGraph graph, EdgeSortOrder order) {
        Collection<Edge> edges      = graph.edges();
        ArrayList<Edge> list_edges  = new ArrayList<>(edges);

        Collections.sort(list_edges, (order==EdgeSortOrder.NONDECREASING) ? new EdgeWeightComparator() : new EdgeWeightComparator().reversed());

        return list_edges;
    }

}
