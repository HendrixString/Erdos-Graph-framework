package com.hendrix.graph.graphs;

import com.hendrix.graph.graphs.engines.IGraphEngine;
import com.hendrix.graph.graphs.engines.IGraphRepresentation;
import com.hendrix.graph.interfaces.IDisposable;
import com.hendrix.graph.interfaces.IId;
import com.hendrix.graph.interfaces.ITag;
import com.hendrix.graph.types.IVertex;

/**
 * Adjacency-list is embedded inside the vertex for optimality
 * @author Tomer Shalev
 */
public interface IGraph extends IGraphRepresentation, IId, ITag, IDisposable, Iterable<IVertex>
{
    /**
     * get the graph engine
     *
     * @return IGraphEngine
     * @see com.hendrix.graph.graphs.engines.IGraphEngine
     */
    IGraphEngine getGraphEngine();

    /**
     * the graph engine instantiation factory
     *
     * @return a graph engine
     *
     * @see com.hendrix.graph.graphs.engines.IGraphEngine
     * @see com.hendrix.graph.graphs.engines.AbstractGraphEngine
     */
    IGraphEngine graphEngineFactory();

    /**
     * does this graph support multi edges
     *
     * @return {@code true, false}
     */
    boolean hasMultiEdges();

    /**
     * does this graph support self loops
     *
     * @return {@code true, false}
     */
    boolean hasSelfLoops();

    void print();
}
