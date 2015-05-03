package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.graphs.engines.IGraphEngine;

/**
 * undirected multi graph
 * @author Tomer Shalev
 */
public class DirectedPseudoGraph extends DirectedGraph {

    @Override
    public boolean hasMultiEdges() {
        return true;
    }

    @Override
    public boolean hasSelfLoops() {
        return true;
    }

    public AdjIncidenceGraphEngine getTypedGraphEngine() {return (AdjIncidenceGraphEngine)getGraphEngine();}

    @Override
    public IGraphEngine graphEngineFactory() {
        return new AdjIncidenceGraphEngine();
    }
}
