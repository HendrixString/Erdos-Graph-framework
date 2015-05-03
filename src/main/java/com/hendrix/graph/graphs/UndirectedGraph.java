package com.hendrix.graph.graphs;

import com.hendrix.graph.types.IVertex;
import com.hendrix.graph.types.Edge;

/**
 * @author Tomer Shalev
 */
abstract public class UndirectedGraph extends AbstractGraph implements IUndirectedGraph {

    @Override
    public Edge.EDGE_DIRECTION getGraphType() {
        return Edge.EDGE_DIRECTION.UNDIRECTED;
    }



    /**
     * @param vertex the vertex in question
     * @return the out degree of  the vertex
     */
    @Override
    public int degreeOfVertex(IVertex vertex) {
        return getGraphEngine().inDegreeOfVertex(vertex);
    }
}
