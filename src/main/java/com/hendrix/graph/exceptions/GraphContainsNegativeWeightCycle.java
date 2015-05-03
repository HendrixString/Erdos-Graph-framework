package com.hendrix.graph.exceptions;

import com.hendrix.graph.algorithms.IGraphAlgorithm;

/**
 * @author Tomer Shalev
 */
public class GraphContainsNegativeWeightCycle extends AlgorithmException {

    public GraphContainsNegativeWeightCycle(IGraphAlgorithm algorithm) {
        super("Single Source Shortest Path on a graph with negative weight cycle!!", algorithm);
    }
}
