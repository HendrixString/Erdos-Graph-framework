package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.types.IVertex;
import com.hendrix.graph.types.Edge;

/**
 * @author Tomer Shalev
 */
abstract public class DirectedGraph extends AbstractGraph implements IDirectedGraph {

    public DirectedGraph() {
    }

    /**
     * @param vertex the vertex in question
     *
     * @return the out degree of  the vertex
     *
     */
    public int outDegreeOfVertex(IVertex vertex) {
        return getGraphEngine().outDegreeOfVertex(vertex);
    }

    /**
     * @param vertex the vertex in question
     *
     * @return the in degree of  the vertex
     *
     */
    @SuppressWarnings("UnusedDeclaration")
    public int inDegreeOfVertex(IVertex vertex) {
        return getGraphEngine().inDegreeOfVertex(vertex);
    }

    @Override
    public Edge.EDGE_DIRECTION getGraphType() {
        return Edge.EDGE_DIRECTION.DIRECTED;
    }
}
