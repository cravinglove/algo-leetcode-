package union_find;

public class Number_of_Island {
    int[][] distance = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int rows, cols;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; i++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < cols && y > 0 && y < rows && grid[x][y] == '1') {
                            uf.union(node(i, j), node(x, y));
                        }
                    }
                }
            }
        }
        return uf.count();
    }

    private int node(int x, int y) {
        return x * cols + y;
    }

    private class WeightedQuickUnionUF {
        private int[] parents;
        private int[] size;
        private int count;

        public WeightedQuickUnionUF(int n) {
            count = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int count() {return count;}

        public boolean connected(int p, int q) {return find(p) == find(q);}

        public int find(int p) {
            while (p != parents[p])
                p = parents[p];
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] < size[rootQ]) {
                parents[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else {
                parents[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
