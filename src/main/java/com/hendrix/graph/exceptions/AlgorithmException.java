package com.hendrix.graph.exceptions;

import com.hendrix.graph.algorithms.IGraphAlgorithm;

/**
 * algorithm exception
 *
 * @author Tomer Shalev
 */
public class AlgorithmException extends RuntimeException {
    public AlgorithmException(String message, IGraphAlgorithm algorithm) {
        super("Algorithm " + algorithm.getTag() + ":: message - " + message);
    }
}
