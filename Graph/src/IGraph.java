import java.util.Stack;

public interface IGraph {
    public void DFS();
    public void BFS();
    public void allPaths(int src, int dest);
    public boolean isCyclic();
    public boolean isCyclicDirected();
    public Stack<Integer> topSort();
    public void Dijkstra(int src);
    public void bellmanFord(int src);
    public int prims();
    public void Kosaraju();
}
