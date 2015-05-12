package com.hendrix.graph;

import com.hendrix.graph.graphs.AbstractGraph;
import com.hendrix.graph.graphs.DirectedGraph;
import com.hendrix.graph.graphs.IGraph;
import com.hendrix.graph.graphs.UndirectedGraph;
import com.hendrix.graph.graphs.engines.IGraphEngine;
import com.hendrix.graph.types.Edge.*;

/**
 * Graph instances factory
 *
 * @author Tomer Shalev
 *
 * @see com.hendrix.graph.graphs.IGraph
 * @see com.hendrix.graph.graphs.AbstractGraph
 * @see com.hendrix.graph.graphs.DirectedGraph
 * @see com.hendrix.graph.graphs.UndirectedGraph
 */
public class Graph {
    private Graph() {}

    /**
     * clone empty graph with the same characteristics (graph engine, multi edge support, self loops supprt)
     *
     * @param graph the graph to clone
     *
     * @return an {@link com.hendrix.graph.graphs.AbstractGraph} implementation
     */
    static public AbstractGraph cloneEmptyGraphOf(IGraph graph) {
        return newGraphWithEngine(graph.graphEngineFactory(), graph.getGraphType(), graph.hasSelfLoops(), graph.hasMultiEdges());
    }

    /**
     * clone a graph. the vertices and edges are referenced and not cloned from the original graph.
     *
     * @param graph the graph to copy
     *
     * @return the copied graph
     */
    static public AbstractGraph cloneGraphOf(IGraph graph) {
        AbstractGraph graph_res = newGraphWithEngine(graph.graphEngineFactory(), graph.getGraphType(), graph.hasSelfLoops(), graph.hasMultiEdges());
        graph_res.addAll(graph.vertices(), graph.edges());

        return graph_res;
    }

    /**
     * instantiate a new {@link com.hendrix.graph.graphs.AbstractGraph} implementation. note:
     * <ul>
     *     <li> {@code EDGE_DIRECTION.DIRECTED} will return {@link com.hendrix.graph.graphs.DirectedGraph} implementation.
     *     <li> {@code EDGE_DIRECTION.UNDIRECTED} will return {@link com.hendrix.graph.graphs.UndirectedGraph} implementation.
     * </ul>
     *
     * @param graphEngine   a graph engine
     * @param direction     graph edge direction, as specified in {@link com.hendrix.graph.types.Edge.EDGE_DIRECTION}.
     * @param selfLoops     support for self loops
     * @param multiEdges    support for multi edges
     * @param <T>           a {@link com.hendrix.graph.graphs.engines.IGraphEngine} instance.
     *
     * @return a new graph
     */
    static public <T extends IGraphEngine> AbstractGraph newGraphWithEngine(final T graphEngine, final EDGE_DIRECTION direction,
                                                                            final boolean selfLoops, final boolean multiEdges) {
        switch (direction) {
            case DIRECTED:
                return newDirectedGraphWithEngine(graphEngine, selfLoops, multiEdges);
            case UNDIRECTED:
                return newUndirectedGraphWithEngine(graphEngine, selfLoops, multiEdges);
        }

        return null;
    }

    /**
     * instantiate a new {@link com.hendrix.graph.graphs.DirectedGraph} implementation. note:
     *
     * @param graphEngine   a graph engine
     * @param selfLoops     support for self loops
     * @param multiEdges    support for multi edges
     * @param <T>           a {@link com.hendrix.graph.graphs.engines.IGraphEngine} instance.
     *
     * @return a new graph
     */
    static private <T extends IGraphEngine> DirectedGraph newDirectedGraphWithEngine(final T graphEngine, final boolean selfLoops,
                                                                                     final boolean multiEdges) {
        return new DirectedGraph() {
            @Override
            public boolean hasMultiEdges() {
                return multiEdges;
            }

            @Override
            public boolean hasSelfLoops() {
                return selfLoops;
            }

            @Override
            public IGraphEngine graphEngineFactory() {
                return graphEngine;
            }
        };
    }

    /**
     * instantiate a new {@link com.hendrix.graph.graphs.UndirectedGraph} implementation. note:
     *
     * @param graphEngine   a graph engine
     * @param selfLoops     support for self loops
     * @param multiEdges    support for multi edges
     * @param <T>           a {@link com.hendrix.graph.graphs.engines.IGraphEngine} instance.
     *
     * @return a new graph
     */
    static private <T extends IGraphEngine> UndirectedGraph newUndirectedGraphWithEngine(final T graphEngine, final boolean selfLoops,
                                                                                         final boolean multiEdges) {
        return new UndirectedGraph() {
            @Override
            public boolean hasMultiEdges() {
                return multiEdges;
            }

            @Override
            public boolean hasSelfLoops() {
                return selfLoops;
            }

            @Override
            public IGraphEngine graphEngineFactory() {
                return graphEngine;
            }
        };
    }

}
