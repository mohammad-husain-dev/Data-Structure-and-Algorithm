import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GraphALImplementation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int V=5;
        /// creating a graph with 5 vertices
        /*		1---2
         *    /		|
         *   0		|
         *    \     |
         *    	4---3
         */
        //System.out.println("Hello World");
        Graph g=new Graph(V);
        g.addEdge(0, 1);
        g.addEdge(1, 0);

        g.addEdge(1, 2);
        g.addEdge(2, 1);

        g.addEdge(2, 3);
        g.addEdge(3, 2);

        g.addEdge(3, 4);
        g.addEdge(4, 3);

        g.addEdge(4, 0);
        g.addEdge(0, 4);

        // add extra edge between 1 and 3
        //g.addEdge(1, 3);
        //g.addEdge(3, 1);

        /// BFS
        g.BFS();

        // DFS
        // g.DFS();

        // all paths from 0-->3
        //g.allPaths(0, 3);

        // cycle in undirected graph
        //System.out.println(g.isCyclic());

        /*
         *
         * 3--> 0 --> 1
         * 		^	  |
         * 		|	  v
         * 		------2
         */
//		Graph g_d=new Graph(5);
//		g_d.addEdge(0, 1);
//		g_d.addEdge(2, 1);
//		g_d.addEdge(2, 3);
//		g_d.addEdge(3, 4);
//		//g_d.addEdge(4, 2);
//
//		//g_d.BFS();
//		System.out.println(g_d.isCyclicDirected());

        /*
         *
         *
         *
         *
         *
         */
//		Graph g3=new Graph(6);
//		g3.addEdge(4, 1);
//		g3.addEdge(4, 0);
//
//		g3.addEdge(5, 0);
//		g3.addEdge(5, 2);
//
//		g3.addEdge(2, 3);
//		g3.addEdge(3, 1);
//
//		g3.topSort();

        /*
         *
         * Dijkstra's Algorithm
         *
         */
//		Graph g4=new Graph(6);
//		g4.addEdge(0, 1, 2);
//		g4.addEdge(0, 2, 4);
//		g4.addEdge(1, 2, 1);
//		g4.addEdge(1, 3, 7);
//		g4.addEdge(2, 4, 3);
//		g4.addEdge(3, 5, 1);
//		g4.addEdge(4, 3, 2);
//		g4.addEdge(4, 5, 5);
//
//		g4.Dijkstra(0);
//		g4.bellmanFord(0);

        /*
         *
         * Bellmanford Algorithm
         *
         */
//		Graph g5=new Graph(5);
//		g5.addEdge(0, 2, 4);
//		g5.addEdge(0, 1, 2);
//		g5.addEdge(1, 2, -4);
//		g5.addEdge(2, 3, 2);
//		g5.addEdge(3, 4, 4);
//		g5.addEdge(4, 1, -1);
//
//		g5.bellmanFord(0);

        /*
         *
         * Prims Algorithm
         *
         */
//		Graph g6=new Graph(4);
//		g6.addEdge(0, 1, 10);
//		g6.addEdge(0, 2, 15);
//		g6.addEdge(0, 3, 30);
//		g6.addEdge(1, 3, 40);
//		g6.addEdge(2, 3, 50);
//
//		System.out.println(g6.prims());

        /*
         *
         * Kosaraju's Algorithm
         *
         */
//		Graph g7=new Graph(5);
//		g7.addEdge(0, 3);
//		g7.addEdge(0, 2);
//		g7.addEdge(1, 0);
//		g7.addEdge(2, 1);
//		g7.addEdge(3, 4);

//		Stack<Integer> stack=g7.topSort();
//		while(!stack.empty()) System.out.print(stack.pop() +" ");
        //g7.Kosaraju();

    }

}