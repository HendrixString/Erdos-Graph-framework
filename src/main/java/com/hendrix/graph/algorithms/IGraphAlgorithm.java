package com.hendrix.graph.algorithms;

import com.hendrix.graph.interfaces.IDisposable;
import com.hendrix.graph.graphs.IGraph;
import com.hendrix.graph.interfaces.ITag;

/**
 * a generic graph algorithm interface
 * @param <T> the result of the algorithm
 * @param <E> the input type of the algorithm
 * @see com.hendrix.graph.graphs.IGraph
 * @author Tomer Shalev
 */
@SuppressWarnings("UnusedDeclaration")
public interface IGraphAlgorithm<T, E extends IGraph> extends IDisposable, ITag
{
    /**
     * @param graph the graph on which to apply the algorithm
     */
    void setInputGraph(E graph);

    /**
     * @return the input graph
     */
    E getInputGraph();

    /**
     * apply the algorithm on the graph
     */
    T applyAlgorithm();

    /**
     * get the algorithm result
     */
    T getResult();

}
