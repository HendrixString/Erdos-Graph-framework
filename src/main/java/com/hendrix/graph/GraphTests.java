package com.hendrix.graph;

import com.hendrix.graph.algorithms.AllPairsShortPathResult;
import com.hendrix.graph.algorithms.BFS;
import com.hendrix.graph.algorithms.BellmanFordShortestPath;
import com.hendrix.graph.algorithms.DFS;
import com.hendrix.graph.algorithms.DijkstraShortestPath;
import com.hendrix.graph.algorithms.FloydWarshall;
import com.hendrix.graph.algorithms.MSTKruskal;
import com.hendrix.graph.algorithms.MSTPrim;
import com.hendrix.graph.algorithms.SCC;
import com.hendrix.graph.algorithms.ShortestPathsTree;
import com.hendrix.graph.algorithms.TopologicalSort;
import com.hendrix.graph.algorithms.TransitiveClosure;
import com.hendrix.graph.algorithms.factories.AllPairsShortPathFactory;
import com.hendrix.graph.exceptions.AlgorithmException;
import com.hendrix.graph.graphs.AbstractGraph;
import com.hendrix.graph.graphs.IDirectedGraph;
import com.hendrix.graph.graphs.SimpleDirectedGraph;
import com.hendrix.graph.graphs.SimpleGraph;
import com.hendrix.graph.graphs.UndirectedGraph;
import com.hendrix.graph.graphs.engines.AdjIncidenceGraphEngine;
import com.hendrix.graph.types.DirectedEdge;
import com.hendrix.graph.types.IVertex;
import com.hendrix.graph.types.Edge;
import com.hendrix.graph.types.Vertex;
import com.hendrix.graph.utils.SMatrixUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Tomer Shalev
 */
public class GraphTests {
    //private AbstractGraph<IGraphEngine> graph;
    //private AbstractGraph graph;
    private IVertex _v0;

    public GraphTests() {
        AbstractGraph ag = Graph.newGraphWithEngine(new AdjIncidenceGraphEngine(), Edge.EDGE_DIRECTION.DIRECTED, false, false);

        //generalTest();
        //mst();
        //BellmanFord();
        //DijkstraShortestPath();
        //matrixUtils();
        floyd_Warshall_and_johnson();
        //transitiveClosure();
    }

    private void transitiveClosure() {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();

        Vertex v1 = new Vertex();
        v1.setTag("1");
        Vertex v2 = new Vertex();
        v2.setTag("2");
        Vertex v3 = new Vertex();
        v3.setTag("3");
        Vertex v4 = new Vertex();
        v4.setTag("4");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        Edge e2_3     = new DirectedEdge(v2, v3, 3);
        Edge e2_4     = new DirectedEdge(v2, v4, 8);

        Edge e3_2     = new DirectedEdge(v3, v2, 8);

        Edge e4_1     = new DirectedEdge(v4, v1, 8);
        Edge e4_3     = new DirectedEdge(v4, v3, 8);

        graph.addEdge(e2_3);
        graph.addEdge(e2_4);
        graph.addEdge(e3_2);
        graph.addEdge(e4_1);
        graph.addEdge(e4_3);


        IDirectedGraph graph_res = new TransitiveClosure(graph).applyAlgorithm();

        graph_res.print();

        System.out.println("");

    }

    private void floyd_Warshall_and_johnson() {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();

        Vertex v1 = new Vertex();
        v1.setTag("1");
        Vertex v2 = new Vertex();
        v2.setTag("2");
        Vertex v3 = new Vertex();
        v3.setTag("3");
        Vertex v4 = new Vertex();
        v4.setTag("4");
        Vertex v5 = new Vertex();
        v5.setTag("5");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        Edge e1_2     = new DirectedEdge(v1, v2, 3);
        Edge e1_3     = new DirectedEdge(v1, v3, 8);
        Edge e1_5     = new DirectedEdge(v1, v5, -4);

        Edge e2_4     = new DirectedEdge(v2, v4, 1);
        Edge e2_5     = new DirectedEdge(v2, v5, 7);

        Edge e3_2     = new DirectedEdge(v3, v2, 4);

        Edge e4_1     = new DirectedEdge(v4, v1, 2);
        Edge e4_3     = new DirectedEdge(v4, v3, -5);

        Edge e5_4     = new DirectedEdge(v5, v4, 6);

        graph.addEdge(e1_2);
        graph.addEdge(e1_3);
        graph.addEdge(e1_5);
        graph.addEdge(e2_4);
        graph.addEdge(e2_5);
        graph.addEdge(e3_2);
        graph.addEdge(e4_1);
        graph.addEdge(e4_3);
        graph.addEdge(e5_4);

        AllPairsShortPathResult floyd_result = new FloydWarshall(graph).applyAlgorithm();

        floyd_result.shortestPathsTreeOf(v1).print();

        System.out.println(floyd_result.shortestPathBetween(v5, v2).toString());

        AllPairsShortPathResult johnson_result = AllPairsShortPathFactory.newAllPairsShortPath(graph, AllPairsShortPathFactory.APSPAlgorithm.Johnson);


        System.out.println("");
    }

    private void matrixUtils()
    {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();

        Vertex s = new Vertex();
        s.setTag("s");
        Vertex t = new Vertex();
        t.setTag("t");
        Vertex x = new Vertex();
        x.setTag("x");
        Vertex y = new Vertex();
        y.setTag("y");
        Vertex z = new Vertex();
        z.setTag("z");

        graph.addVertex(s);
        graph.addVertex(t);
        graph.addVertex(x);
        graph.addVertex(y);
        graph.addVertex(z);

        Edge e1     = new Edge(s, t, Edge.EDGE_DIRECTION.DIRECTED, 10);
        Edge e2     = new Edge(t, x, Edge.EDGE_DIRECTION.DIRECTED, 1);
        Edge e3     = new Edge(s, y, Edge.EDGE_DIRECTION.DIRECTED, 5);
        Edge e4     = new Edge(y, z, Edge.EDGE_DIRECTION.DIRECTED, 2);
        Edge e5     = new Edge(z, x, Edge.EDGE_DIRECTION.DIRECTED, 6);
        Edge e6     = new Edge(t, y, Edge.EDGE_DIRECTION.DIRECTED, 2);
        Edge e7     = new Edge(y, t, Edge.EDGE_DIRECTION.DIRECTED, 3);
        Edge e8     = new Edge(x, z, Edge.EDGE_DIRECTION.DIRECTED, 4);
        Edge e9     = new Edge(y, x, Edge.EDGE_DIRECTION.DIRECTED, 9);
        Edge e10    = new Edge(z, s, Edge.EDGE_DIRECTION.DIRECTED, 7);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);
        graph.addEdge(e7);
        graph.addEdge(e8);
        graph.addEdge(e9);
        graph.addEdge(e10);

        float[][] matrix_adjacency  = SMatrixUtils.adjacencyMatrixOf(graph, 0f, true, Float.POSITIVE_INFINITY);
        float[][] matrix_adjacency2 = SMatrixUtils.adjacencyMatrixOf(graph, 0f, true, Float.POSITIVE_INFINITY);
        float[][] matrix_incidence  = SMatrixUtils.incidenceMatrixOf(graph);

        System.out.println("");
    }

    private void DijkstraShortestPath()
    {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();

        Vertex s = new Vertex();
        s.setTag("s");
        Vertex t = new Vertex();
        t.setTag("t");
        Vertex x = new Vertex();
        x.setTag("x");
        Vertex y = new Vertex();
        y.setTag("y");
        Vertex z = new Vertex();
        z.setTag("z");

        graph.addVertex(s);
        graph.addVertex(t);
        graph.addVertex(x);
        graph.addVertex(y);
        graph.addVertex(z);

        Edge e_s_t  = new DirectedEdge(s, t, 10);
        Edge e_t_x  = new DirectedEdge(t, x, 1);
        Edge e_s_y  = new DirectedEdge(s, y, 5);
        Edge e_y_z  = new DirectedEdge(y, z, 2);
        Edge e_z_x  = new DirectedEdge(z, x, 6);
        Edge e_t_y  = new DirectedEdge(t, y, 2);
        Edge e_y_t  = new DirectedEdge(y, t, 3);
        Edge e_x_z  = new DirectedEdge(x, z, 4);
        Edge e_y_x = new DirectedEdge(y, x, 9);
        Edge e_z_s = new DirectedEdge(z, s, 7);

        graph.addEdge(e_s_t);
        graph.addEdge(e_t_x);
        graph.addEdge(e_s_y);
        graph.addEdge(e_y_z);
        graph.addEdge(e_z_x);
        graph.addEdge(e_t_y);
        graph.addEdge(e_y_t);
        graph.addEdge(e_x_z);
        graph.addEdge(e_y_x);
        graph.addEdge(e_z_s);

        graph.print();

        ShortestPathsTree res = new DijkstraShortestPath(graph).setStartVertex(s).applyAlgorithm();

        res.print();

        System.out.println("");
    }

    private void BellmanFord()
    {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();

        Vertex s = new Vertex();
        s.setTag("s");
        Vertex t = new Vertex();
        t.setTag("t");
        Vertex x = new Vertex();
        x.setTag("x");
        Vertex y = new Vertex();
        y.setTag("y");
        Vertex z = new Vertex();
        z.setTag("z");

        graph.addVertex(s);
        graph.addVertex(t);
        graph.addVertex(x);
        graph.addVertex(y);
        graph.addVertex(z);

        Edge e1 = new Edge(s, t, Edge.EDGE_DIRECTION.DIRECTED, 6);
        Edge e2 = new Edge(t, x, Edge.EDGE_DIRECTION.DIRECTED, 5);
        Edge e3 = new Edge(x, t, Edge.EDGE_DIRECTION.DIRECTED, -2);
        Edge e4 = new Edge(s, y, Edge.EDGE_DIRECTION.DIRECTED, 7);
        Edge e5 = new Edge(y, z, Edge.EDGE_DIRECTION.DIRECTED, 9);
        Edge e6 = new Edge(t, y, Edge.EDGE_DIRECTION.DIRECTED, 8);
        Edge e7 = new Edge(z, x, Edge.EDGE_DIRECTION.DIRECTED, 7);
        Edge e8 = new Edge(t, z, Edge.EDGE_DIRECTION.DIRECTED, -4);
        Edge e9 = new Edge(y, x, Edge.EDGE_DIRECTION.DIRECTED, -3);
        Edge e10 = new Edge(z, s, Edge.EDGE_DIRECTION.DIRECTED, 2);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);
        graph.addEdge(e7);
        graph.addEdge(e8);
        graph.addEdge(e9);
        graph.addEdge(e10);

        graph.setTag("graph");

        graph.print();

        ShortestPathsTree res = new BellmanFordShortestPath(graph).setStartVertex(s).applyAlgorithm();

        res.print();

        System.out.println("");
    }

    private void generalTest() {
        SimpleDirectedGraph graph = new SimpleDirectedGraph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();

        Vertex v3 = new Vertex();

        _v0 = v0;

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);

        graph.addEdge(v1, v2);

        graph.addEdge(v2, v3);
        graph.addEdge(v2, v0);

        graph.print();

        //
        Collection<IVertex> coll = graph.vertices();
        Collection<Edge> coll_edges = graph.edges();
        //coll.remove(v0);

        for(Iterator<Edge> iter = coll_edges.iterator(); iter.hasNext();) {
            Edge edge = iter.next();
            //iter.remove();
        }

        for(Iterator<IVertex> iter = coll.iterator(); iter.hasNext();) {
            IVertex vv = iter.next();
             //iter.remove();
        }


        for (IVertex vertex : graph) {

        }

        for (IVertex vertex : coll) {
            //System.out.println(vertex.getId());
        }


        //
        BFS.BreadthFirstTree breadthFirstTree = new BFS(graph, _v0).applyAlgorithm();

        breadthFirstTree.print();

        for (Edge edge : breadthFirstTree.edges()) {
            System.out.print(edge.toString() + ",");
        }

        DFS.DepthFirstForest depthFirstForest = new DFS(graph).applyAlgorithm();

        depthFirstForest.print();

        for (Edge edge : depthFirstForest.edges()) {
            System.out.print(edge.toString() + ",");
        }

        ArrayList<HashSet<IVertex>> hashSets = new SCC(graph).applyAlgorithm();

        for (HashSet<IVertex> hashSet : hashSets) {

            System.out.print("SCC : {");
            for (IVertex vertex : hashSet) {

                System.out.print(vertex.getId() + ",");
            }

            System.out.println("}");

        }

        try {
            LinkedList<IVertex> res_sort = new TopologicalSort(graph).applyAlgorithm();
            System.out.println("TopoSort");

            for (int i = 0; i < res_sort.size(); i++) {
                System.out.print(res_sort.get(i).getId() + ",");
            }
        }catch (AlgorithmException err){
            err.printStackTrace();
        }

    }

    private void mst()
    {
        UndirectedGraph graph = new SimpleGraph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        Edge e1 = new Edge(v0, v1, Edge.EDGE_DIRECTION.UNDIRECTED, 1);
        Edge e2 = new Edge(v0, v2, Edge.EDGE_DIRECTION.UNDIRECTED, 5);
        Edge e3 = new Edge(v1, v2, Edge.EDGE_DIRECTION.UNDIRECTED, 2);
        Edge e4 = new Edge(v2, v3, Edge.EDGE_DIRECTION.UNDIRECTED, 21);
        Edge e5 = new Edge(v1, v3, Edge.EDGE_DIRECTION.UNDIRECTED, 27);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);

        graph.print();

        UndirectedGraph mst_kruskal = new MSTKruskal(graph).applyAlgorithm();

        mst_kruskal.print();

        UndirectedGraph mst_prim = new MSTPrim(graph).setStartVertex(v0).applyAlgorithm();

        mst_prim.print();

    }

}
