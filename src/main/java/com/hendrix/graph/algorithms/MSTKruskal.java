package com.hendrix.graph.algorithms;

import com.hendrix.collection.NaiveUnionFind;
import com.hendrix.graph.graphs.IUndirectedGraph;
import com.hendrix.graph.graphs.SimpleGraph;
import com.hendrix.graph.graphs.UndirectedGraph;
import com.hendrix.graph.utils.SGraphUtils.EdgeSortOrder;
import com.hendrix.graph.exceptions.AlgorithmException;
import com.hendrix.graph.types.IVertex;
import com.hendrix.graph.types.Edge;
import com.hendrix.graph.utils.SGraphUtils;

import java.util.ArrayList;

/**
 * computes a minimum spanning forest
 *
 * @author Tomer Shalev
 * @see com.hendrix.graph.algorithms.factories.MinSpanTreeFactory
 */
@SuppressWarnings("UnusedDeclaration")
public class MSTKruskal extends GraphAlgorithm<UndirectedGraph, IUndirectedGraph> {

    public MSTKruskal(IUndirectedGraph graph_input) {
        super(graph_input, "MST_Kruskal");
    }

    @Override
    public UndirectedGraph applyAlgorithm() {
        if(_graph_input==null)
            throw new AlgorithmException("_graph_input==null", this);

        if(_graph_input.getGraphType()== Edge.EDGE_DIRECTION.DIRECTED)
            throw new AlgorithmException("graph type must be undirected!", this);

        mst();

        return _result_algorithm;
    }

    /*
    MST-KRUSKAL(G, w)
    1  A ← Ø
    2  for each vertex v ∈ V[G]
    3       do MAKE-SET(v)
    4  sort the edges of E into non decreasing order by weight w
    5  for each edge (u, v) ∈ E, taken in non decreasing order by weight
    6       do if FIND-SET(u) ≠ FIND-SET(v)
    7             then A ← A ∪ {(u, v)}
    8                  UNION(u, v)
    9  return A
    */
    protected void mst()
    {
        _result_algorithm = new SimpleGraph();
        _result_algorithm.setTag(getTag() + " result");

        NaiveUnionFind<IVertex> unionFind = new NaiveUnionFind<>();

        for (IVertex vertex : _graph_input.vertices()) {
            unionFind.MAKESET(vertex);
        }

        ArrayList<Edge> list_edges = SGraphUtils.sortWeightedEdgesOf(_graph_input, EdgeSortOrder.NONDECREASING);//new ArrayList<>(edges);

        for (Edge edge : list_edges) {
            if(unionFind.FINDSET(edge.getV1()) != unionFind.FINDSET(edge.getV2())) {
                _result_algorithm.addVertex(edge.getV1());
                _result_algorithm.addVertex(edge.getV2());
                _result_algorithm.addEdge(edge);
                unionFind.UNION(edge.getV1(), edge.getV2());
            }
        }

    }

}
