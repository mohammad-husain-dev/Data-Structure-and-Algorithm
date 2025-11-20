public class Edge
{
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest)
    {
        this.src=src;
        this.dest=dest;
    }

    public Edge(int src, int dest, int wt)
    {
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }

    public void setWt(int wt)
    {
        this.wt=wt;
    }

    public int getWt()
    {
        return this.wt;
    }
}