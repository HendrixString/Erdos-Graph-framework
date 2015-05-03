package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.IGraphEngine;
import com.hendrix.graph.types.IVertex;

/**
 * @author Tomer Shalev
 */
public interface IUndirectedGraph extends IGraph {
    /**
     * @param vertex the vertex in question
     *
     * @return the out degree of  the vertex
     */
    int degreeOfVertex(IVertex vertex);

}
