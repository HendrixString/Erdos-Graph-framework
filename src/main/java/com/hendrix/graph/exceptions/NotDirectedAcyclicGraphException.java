package com.hendrix.graph.exceptions;

import com.hendrix.graph.algorithms.IGraphAlgorithm;

/**
 * @author Tomer Shalev
 */
public class NotDirectedAcyclicGraphException extends AlgorithmException {

    public NotDirectedAcyclicGraphException(IGraphAlgorithm algorithm) {
        super("Topological sorting on a non DAG", algorithm);
    }
}
