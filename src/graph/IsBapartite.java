package graph;

public class IsBapartite {
    public boolean is(int[][] graph) {
        boolean[] mark = new boolean[graph.length];
        boolean[] color = new boolean[graph.length + 1];

        for(int i = 0; i < graph.length; i++) {
            if(!mark[i]) dfs(graph, mark, color, i);
            if(color[graph.length]) return false;
        }
        return true;
    }

    private void dfs(int[][] graph, boolean[] mark, boolean[] color, int i) {
        mark[i] = true;
        for(int adj : graph[i]) {
            if(!mark[adj]) {
                color[adj] = !color[i];
                dfs(graph, mark, color, adj);
            } else if(color[adj] == color[i]) {color[graph.length] = true; return;}
        }
    }
}
