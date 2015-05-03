package com.hendrix.graph.algorithms;

import com.hendrix.graph.exceptions.AlgorithmException;
import com.hendrix.graph.exceptions.NotDirectedAcyclicGraphException;
import com.hendrix.graph.graphs.IDirectedGraph;
import com.hendrix.graph.types.IVertex;

import java.util.LinkedList;

/**
 * computes a Topological Sort of input Graph G
 * @author Tomer Shalev
 */
public class TopologicalSort extends GraphAlgorithm<LinkedList<IVertex>, IDirectedGraph> {

    public TopologicalSort(IDirectedGraph graph_input) {
        super(graph_input, "TopologicalSort");
    }

    @Override
    public LinkedList<IVertex> applyAlgorithm() {
        if(_graph_input==null)
            throw new AlgorithmException("_graph_input==null", this);

        sort();

        return _result_algorithm;
    }

    protected void sort()
    {
        DFS.DepthFirstForest dff = new DFS(_graph_input).applyAlgorithm();

        if(dff.isFlagContainsCycle())
            throw new NotDirectedAcyclicGraphException(this);

        _result_algorithm = dff.get_F_SORTED();
    }

}
