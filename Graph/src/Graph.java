import java.util.*;

public class Graph implements IGraph
{
    ArrayList<Edge> graph[];

    public Graph(int V)
    {
        graph=new ArrayList[V];
        for(int i=0;i<V;i++)
            graph[i]=new ArrayList<Edge>();
    }

    public void addEdge(int src, int dest)
    {
        Edge e=new Edge(src, dest);
        graph[src].add(e);
    }

    public void addEdge(int src, int dest, int wt)
    {
        Edge e=new Edge(src, dest, wt);
        graph[src].add(e);
    }

    //// DFS /////
    public void DFS()
    {
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                DFSUtil(i, vis);
        }
    }

    private void DFS1(int i, boolean[] vis)
    {
        vis[i]=true;
        System.out.println(i);

        for(Edge n: graph[i])
        {
            if(!vis[n.dest])
                DFS1(n.dest, vis);
        }
    }

    private void DFSUtil(int s, boolean[] vis)
    {
        if(!vis[s])
        {
            System.out.println(s);
            vis[s]=true;

            ArrayList<Edge> nbr=graph[s];
            for(Edge e:nbr)
            {
                DFSUtil(e.src, vis);
            }
        }
    }

    //// BFS ///////
    public void BFS()
    {
        boolean[] vis=new boolean[graph.length];
        /// this loop is to avoid any
        /// unconnected portion of the graph untouched
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                BFSUtil(i, vis);
            }
        }
    }

    private void BFSUtil(int start, boolean[] vis)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);

        while(!q.isEmpty())
        {
            int s=q.remove();
            if(!vis[s])
            {
                System.out.println(s);
                vis[s]=true;

                ArrayList<Edge> nbr=graph[s];
                for(Edge e:nbr)
                {
                    q.add(e.dest);
                }
            }
        }
    }

    //// All Paths /////
    public void allPaths(int src, int dest)
    {
        boolean[] vis=new boolean[graph.length];
        ArrayList<Integer> path=new ArrayList();
        path.add(src);
        allPathsUtil_1(src, dest, vis, path);
    }

    private void allPathsUtil(int src, int dest, boolean[] vis, ArrayList<Integer> path)
    {
        if(src==dest)
        {
            //path.add(dest);
            for(int i: path)
                System.out.print(i);
            System.out.println();
            //path.removeLast();
            return;
        }

        if(!vis[src])
        {
            path.add(src);
            vis[src]=true;

            ArrayList<Edge> nbr=graph[src];
            for(Edge e:nbr)
            {
                allPathsUtil(e.dest, dest, vis, path);
            }
            vis[src]=false;
            path.removeLast();
        }
    }

    private void allPathsUtil_1(int src, int dest, boolean[] vis, ArrayList<Integer> path)
    {
        if(src==dest)
        {
            for(int i: path)
                System.out.print(i);
            System.out.println();
            return;
        }

        vis[src]=true;

        /*
         * 1. make the current node visited
         * 2. loop over nbrs
         * 	1. if any nbr is unvisited, make it the part of path
         * 	2. explore the paths from that unvisited node
         * 	3. remove that unvisited node from path (backtracking the result)
         * 4. make the current node unvisited to include it in the any other possibility
         *
         */

        ArrayList<Edge> nbr=graph[src];
        for(Edge e:nbr)
        {
            if(!vis[e.dest]) {
                path.add(e.dest);
                allPathsUtil_1(e.dest, dest, vis, path);
                path.removeLast();
            }
        }

        vis[src]=false;
    }

    /// cycle in undirected graph
    public boolean isCyclic()
    {
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                if(isCyclicUtil(i, vis, -1))
                    return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int s, boolean[] vis, int parent)
    {
        vis[s]=true;

        for(Edge e:graph[s])
        {
            if(vis[e.dest])
            {
                if(e.dest==parent)
                    continue;
                else
                    return true;
            }else {
                if(isCyclicUtil(e.dest, vis, s))
                    return true;
            }

        }

        return false;
    }

    /// cycle in directed graph
    public boolean isCyclicDirected()
    {
        boolean[] vis=new boolean[graph.length];
        boolean[] rec_stack=new boolean[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                if(isCyclicDirectedUtil(i, vis, rec_stack))
                    return true;
        }
        return false;
    }

    private boolean isCyclicDirectedUtil(int s, boolean[] vis, boolean[] rec_stack)
    {
        vis[s]=true;
        rec_stack[s]=true;

        for(Edge e:graph[s])
        {
            if(rec_stack[e.dest])  // cycle condition
                return true;
            if(!vis[e.dest])
                if(isCyclicDirectedUtil(e.dest, vis, rec_stack))
                    return true;
        }

        rec_stack[s]=false;
        return false;
    }

    /// Topological sort
    public Stack<Integer> topSort()
    {
        boolean[] vis=new boolean[graph.length];
        Stack<Integer> stack=new Stack<Integer>();

        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                topSortUtil(i, vis, stack);
        }
//
//		while(!stack.empty())
//		{
//			System.out.print(stack.pop() +" ");
//		}
        //System.out.println(stack);
        return stack;
    }

    private void topSortUtil(int s, boolean[] vis, Stack<Integer> stack)
    {
        vis[s]=true;
        for(Edge e:graph[s])
        {
            if(!vis[e.dest])
                topSortUtil(e.dest, vis, stack);
        }
        stack.push(s);
    }


    ///// Dijkstra's Algorithm ////

    class Pair
    {
        int node;
        int dist;

        public Pair(int node, int dist)
        {
            this.node=node;
            this.dist=dist;
        }
    }

    class MyComparator implements Comparator<Pair>
    {

        @Override
        public int compare(Pair o1, Pair o2) {
            // TODO Auto-generated method stub
            return o1.dist-o2.dist;
        }

    }

    public void Dijkstra(int src)
    {
        boolean[] vis=new boolean[graph.length];
        int[] dist=new int[graph.length];
        dist[src]=0;

        for(int i=1;i<graph.length;i++)
            dist[i] = Integer.MAX_VALUE;

        updateDist(src, vis, dist);
        System.out.print("Dijkstra: ");
        for(int i:dist)
            System.out.print(i+" ");
    }

    private void updateDist(int src, boolean[] vis, int[] dist)
    {
        PriorityQueue<Pair> q=new PriorityQueue<Graph.Pair>(new MyComparator());
        q.add(new Pair(src, dist[src]));

        while(!q.isEmpty())
        {
            Pair val=q.poll();
            if(!vis[val.node])
            {
                //TODO: visit the node
                vis[val.node]=true;
                for(Edge e:graph[val.node])
                {
                    if(dist[val.node]+e.wt < dist[e.dest])
                        dist[e.dest]=dist[val.node]+e.wt;
                    q.add(new Pair(e.dest, dist[e.dest]));
                }
            }
        }
    }


    ////// Bellmanford Algorithm
    public void bellmanFord(int src)
    {
        int V=graph.length;

        int[] dist=new int[V];
        dist[src]=0;
        for(int i=1;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }

        ArrayList<Edge> edgeList=new ArrayList();
        for(int i=0;i<V;i++)
        {
            ArrayList<Edge> l=graph[i];
            edgeList.addAll(l);
        }

        for(int i=0;i<V-1;i++)
        {
            for(Edge e:edgeList)
            {
                int u=e.src;
                int v=e.dest;
                if(dist[u]+e.wt<dist[v])
                    dist[v]=dist[u]+e.wt;
            }
        }

        System.out.print("Bellmanford: ");
        for(int i:dist)
        {
            System.out.print(i+" ");
        }
    }


    ////// Prim's Algorithm /////
    public int prims()
    {
        int cost=0;
        PriorityQueue<Pair> pq=new PriorityQueue<Graph.Pair>(new MyComparator());
        int src=0;
        boolean[] vis=new boolean[graph.length];

        pq.add(new Pair(src,0));
        while(!pq.isEmpty())
        {
            Pair p=pq.poll();
            if(!vis[p.node])
            {
                cost=cost+p.dist;
                vis[p.node]=true;

                ArrayList<Edge> nbr=graph[p.node];
                for(Edge e:nbr)
                {
                    if(!vis[e.dest])
                    {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        return cost;
    }



    ///////// Kosaraju Algorithm //////
    /// 1. get the topsort of the grpah
    /// 2. get the transpose of the graph
    /// 3. do DFS on trnaspose of the graph using topsorted stack

    private void tsort(int s, boolean[] vis, Stack<Integer> stack)
    {
        vis[s]=true;
        for(Edge e: graph[s])
        {
            if(!vis[e.dest])
                tsort(e.dest, vis, stack);
        }

        stack.push(s);
    }

    private Graph transpose()
    {
        ArrayList<Edge> edgeList=new ArrayList();
        for(int i=0;i<graph.length;i++)
            edgeList.addAll(graph[i]);

        Graph g=new Graph(graph.length);
        for(Edge e:edgeList)
        {
            g.addEdge(e.dest, e.src);
        }

        return g;
    }

    private void MyDFS(ArrayList<Edge>[] g, int start, boolean[] vis)
    {
        System.out.print(start+" ");
        vis[start]=true;

        for(Edge e:g[start])
        {
            if(!vis[e.dest])
                MyDFS(g, e.dest, vis);
        }
    }

    public void Kosaraju()
    {
        Stack<Integer> stack=new Stack<Integer>();//topSort();
        // 1. topsort
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                tsort(i, vis, stack);
        }

        stack=topSort();
        // 2. transpose of the graph
        Graph transpose_graph=this.transpose();
        vis=new boolean[transpose_graph.graph.length];
        int count=0;
        while(!stack.empty())
        {
            int val=stack.pop();

            if(!vis[val]) {
                count++;
                MyDFS(transpose_graph.graph, val, vis);
                System.out.println("----");
            }
        }

        System.out.println(count);
    }
}