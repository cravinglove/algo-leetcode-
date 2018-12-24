package graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        // Construct map
        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; // duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // enqueue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        // bfs
        while (!queue.isEmpty()) {
            count++;
            int course = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == 1 && --indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
