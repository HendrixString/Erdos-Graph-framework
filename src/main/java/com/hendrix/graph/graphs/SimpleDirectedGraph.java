package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.graphs.engines.IGraphEngine;

/**
 * undirected multi graph
 * @author Tomer Shalev
 */
public class SimpleDirectedGraph extends DirectedGraph {

    public SimpleDirectedGraph() {
    }

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
