package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        initializeGraph(inDegree, adj, prerequisites);

        return solveByBfs(inDegree, adj);
    }

    private void initializeGraph(int[] inDegree, List<List<Integer>> adj, int[][] prerequisites) {
        int n = inDegree.length;
        while (n-- > 0) adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solveByBfs(int[] inDegree, List<List<Integer>> adj) {
        int numCourses = inDegree.length;
        int[] order = new int[numCourses];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) toVisit.offer(i);
        }
        int count = 0;
        while (!toVisit.isEmpty()) {
            int course = toVisit.poll();
            order[count++] = course;
            for (int to : adj.get(course)) {
                if (--inDegree[to] == 0) toVisit.offer(to);
            }
        }
        return count == numCourses ? order : new int[0];
    }
}
