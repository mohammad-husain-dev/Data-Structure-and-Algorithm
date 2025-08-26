public class NumberOfIslands {
	
	public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        NumberOfIslands solver = new NumberOfIslands();
        System.out.println("Number of Islands: " + solver.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length, cols = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        int[][] directions = {{0, 1}, {1, 0}}; // right and down

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni < rows && nj < cols && grid[ni][nj] == '1') {
                            int id1 = i * cols + j;
                            int id2 = ni * cols + nj;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }
}

class UnionFind {
    int[] parent;
    int count;

    public UnionFind(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    int id = i * cols + j;
                    parent[id] = id;
                    count++;
                }
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            count--; // merged two islands
        }
    }

    public int getCount() {
        return count;
    }
}