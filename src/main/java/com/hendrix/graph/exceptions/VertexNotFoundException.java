package com.hendrix.graph.exceptions;

import com.hendrix.graph.graphs.IGraph;
import com.hendrix.graph.types.IVertex;

public class VertexNotFoundException extends GraphException {
    public VertexNotFoundException(IVertex v, IGraph graph) {
        super(v.getId() + " not found in graph", graph);
    }
}
