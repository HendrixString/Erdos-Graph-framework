package com.hendrix.graph.comperators;

import com.hendrix.graph.types.Edge;

import java.util.Comparator;

/**
 * @author Tomer Shalev
 */
public class EdgeWeightComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge o1, Edge o2) {
        return (int)(o1.getWeight() - o2.getWeight());
    }
}
