package com.hendrix.graph.algorithms;

import com.hendrix.graph.Graph;
import com.hendrix.graph.exceptions.AlgorithmException;
import com.hendrix.graph.graphs.AbstractGraph;
import com.hendrix.graph.graphs.IGraph;
import com.hendrix.graph.types.IVertex;

import java.util.Collection;

/**
 * computes the Square graph of input Graph G
 * @author Tomer Shalev
 */
@SuppressWarnings("UnusedDeclaration")
public class Square extends GraphAlgorithm<AbstractGraph, IGraph> {

    public Square(AbstractGraph graph_input) {
        super(graph_input, "Square");
    }

    @Override
    public AbstractGraph applyAlgorithm() {
        if(_graph_input==null)
            throw new AlgorithmException("_graph_input==null", this);

        square();

        return _result_algorithm;
    }

    protected void square()
    {
        _result_algorithm = Graph.cloneEmptyGraphOf(_graph_input);

        // fill the graph V

        Collection<IVertex> vertices = _graph_input.vertices();

        for (IVertex vertex : vertices) {
            _result_algorithm.addVertex(vertex);
        }

        // square

        Collection<IVertex> adjList_v;
        Collection<IVertex> adjList_u;

        for (IVertex v : vertices) {
            adjList_v = _graph_input.getNeighborsOf(v);

            for (IVertex u : adjList_v) {
                adjList_u = _graph_input.getNeighborsOf(u);

                for (IVertex w : adjList_u) {
                    _result_algorithm.addEdge(v, w);
                }

            }

        }

    }

}