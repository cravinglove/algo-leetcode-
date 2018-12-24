package graph;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] cand1 = {-1, -1};
        int[] cand2 = {-1, -1};
        int[] root = new int[edges.length + 1];

        for(int[] edge : edges) {
            int father = edge[0];
            int son = edge[1];
            if(root[son] != 0) {
                cand1 = new int[]{root[son], son};
                cand2 = new int[]{father, son};
                // 标记第二个边为invalid
                edge[1] = 0;
            } else {
                root[son] = father;
            }
        }

        for(int i = 0; i < root.length; i++)
            root[i] = i;

        for(int[] edge : edges) {
            int father = edge[0];
            int son = edge[1];
            if(edge[1] == 0) continue;
            if(find(root, father) == son) {
                if(cand1[0] == -1) return edge;
                else return cand1;
            }
            root[son] = father;
        }
        return cand2;
    }

    private int find(int[] root, int node) {
        while(node != root[node])
            node = root[node];
        return node;
    }
}
