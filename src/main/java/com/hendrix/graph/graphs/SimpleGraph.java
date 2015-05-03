package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.graphs.engines.IGraphEngine;
import com.hendrix.graph.types.Edge;
import com.hendrix.graph.types.IVertex;

import java.util.Collection;

/**
 * undirected simple graph
 *
 * @author Tomer Shalev
 */
public class SimpleGraph extends UndirectedGraph {

    @Override
    public boolean hasMultiEdges() {
        return false;
    }

    @Override
    public boolean hasSelfLoops() {
        return false;
    }

    public AdjIncidenceGraphEngine getTypedGraphEngine() {return (AdjIncidenceGraphEngine)getGraphEngine();}

    @Override
    public IGraphEngine graphEngineFactory() {
        return new AdjIncidenceGraphEngine();
    }
}
