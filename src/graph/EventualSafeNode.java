package graph;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNode {
    // 0 haven't seen
    // 1 unsafe
    // 2 safe
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0) return res;
        int N = graph.length;
        int[] color = new int[N];
        for(int i = 0; i < N; i++) {
            boolean c = dfs(graph, color, i);
            if(c) res.add(i);
        }

        return res;
    }

    private static boolean dfs(int[][] graph, int[] color, int v) {
        if(color[v] != 0) return color[v] == 2;

        color[v] = 1;
        for(int w : graph[v]) {
            if(!dfs(graph, color, w)) return false;
        }
        color[v] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] g = {{1,2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> l = eventualSafeNodes(g);
        System.out.println(l.toString());
    }
}
