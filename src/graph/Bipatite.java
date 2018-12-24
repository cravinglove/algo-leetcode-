package graph;

public class Bipatite {

    public boolean isBipartite(int[][] graph) {
        boolean[] mark = new boolean[graph.length];
        boolean[] color = new boolean[graph.length];
        boolean res = true;

        for(int i = 0; i < graph.length; i++)
            dfs(graph, mark, color, i, res);
        return res;
    }

    private void dfs(int[][] graph, boolean[] mark, boolean[] color, int i, boolean res) {
        mark[i] = true;
        for(int adj : graph[i]) {
            if(!mark[adj]) {
                color[adj] = !color[i];
                dfs(graph, mark, color, adj, res);
            } else if(color[adj] == color[i]) {res=false;return;}
        }
    }
}
