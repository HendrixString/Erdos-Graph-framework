package com.hendrix.graph.exceptions;

import com.hendrix.graph.algorithms.IGraphAlgorithm;

/**
 * @author Tomer Shalev
 */
public class NegativeEdgeWeightException extends AlgorithmException {
    public NegativeEdgeWeightException(IGraphAlgorithm algorithm) {
        super("algorithm does not support negative edge weights!! ", algorithm);
    }
}
