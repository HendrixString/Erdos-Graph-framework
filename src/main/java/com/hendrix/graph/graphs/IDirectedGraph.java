package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.graphs.engines.IGraphEngine;
import com.hendrix.graph.types.IVertex;

/**
 * @author Tomer Shalev
 */
public interface IDirectedGraph extends IGraph {
    /**
     * @param vertex the vertex in question
     *
     * @return the out degree of  the vertex
     */
    int outDegreeOfVertex(IVertex vertex);
    /**
     * @param vertex the vertex in question
     *
     * @return the in degree of  the vertex
     */
    @SuppressWarnings("UnusedDeclaration")
    int inDegreeOfVertex(IVertex vertex);

}
