package graph;

import java.util.Stack;

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        Stack<int[]> stack = new Stack<>();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(edges.length + 1);

        for(int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            if(uf.connected(v, w)) {
                stack.push(edges[i]);
            } else uf.union(v, w);
        }
        if(!stack.isEmpty()) return stack.pop();
        return null;
    }

    private static class WeightedQuickUnionUF {
        private int[] parent;
        private int[] size;
        private int count;

        public WeightedQuickUnionUF(int n){
            parent = new int[n];
            size = new int[n];
            count = n;
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int i) {
            while(parent[i] != i) {
                i = parent[i];
            }
            return i;
        }

        public boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        public void union(int i, int j) {
            int idi = find(i);
            int idj = find(j);
            if(i == j) return;
            if(size[idi] < size[idj]) {
                parent[idi] = idj;
                size[idj] += size[idi];
            } else {
                parent[idj] = idi;
                size[idi] += size[idj];
            }
            count--;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2, 3}};
        int[] a = findRedundantConnection(edges);
        System.out.print(a[0]);
    }
}
