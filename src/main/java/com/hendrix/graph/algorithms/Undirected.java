package com.hendrix.graph.algorithms;

import com.hendrix.graph.exceptions.AlgorithmException;
import com.hendrix.graph.graphs.IDirectedGraph;
import com.hendrix.graph.graphs.SimpleGraph;
import com.hendrix.graph.graphs.UndirectedGraph;
import com.hendrix.graph.types.IVertex;

import java.util.Collection;

/**
 * computes a new undirected graph of directed input Graph G
 * @author Tomer Shalev
 */
@SuppressWarnings("UnusedDeclaration")
public class Undirected extends GraphAlgorithm<UndirectedGraph, IDirectedGraph> {

    public Undirected(IDirectedGraph graph_input) {
        super(graph_input, "Transpose");
    }

    @Override
    public UndirectedGraph applyAlgorithm() {
        if(_graph_input==null)
            throw new AlgorithmException("_graph_input==null", this);

        undirect();

        return _result_algorithm;
    }

    protected void undirect()
    {
        _result_algorithm = new SimpleGraph();

        // fill the graph V

        Collection<IVertex> vertices = _graph_input.vertices();

        for (IVertex vertex : vertices) {
            _result_algorithm.addVertex(vertex);
        }

        // square

        Collection<IVertex> adjList_v;

        for (IVertex v : vertices) {
            adjList_v = _graph_input.getNeighborsOf(v);

            for (IVertex u : adjList_v) {
                _result_algorithm.addEdge(u, v);
                _result_algorithm.addEdge(v, u);
            }

        }

    }

}
