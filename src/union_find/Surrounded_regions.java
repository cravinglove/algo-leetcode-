package union_find;

public class Surrounded_regions {
    int rows, cols;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        rows = board.length;
        cols = board[0].length;

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(rows * cols + 1);
        int dummyNode = rows * cols;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        uf.union(node(i, j), dummyNode);
                    }
                    else {
                        if (i > 0 && board[i - 1][j] == 'O') uf.union(node(i - 1, j), node(i, j));
                        if (i < rows - 1 && board[i + 1][j] == 'O') uf.union(node(i + 1, j), node(i, j));
                        if (j > 0 && board[i][j - 1] == 'O') uf.union(node(i, j - 1), node(i, j));
                        if (j < cols - 1 && board[i][j + 1] == 'O') uf.union(node(i, j + 1), node(i ,j));
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && uf.connected(node(i, j), dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int i, int j) {
        return i * cols + j;
    }

    private class WeightedQuickUnionUF {
        private int[] parent;
        private int[] size;
        private int count;

        public WeightedQuickUnionUF (int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {return count;}

        public int find(int p) {
            while (p != parent[p])
                p = parent[p];
            return p;
        }

        public boolean connected (int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
