package strivers.graph.problem;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII implements App {
    @Override
    public void run() {
        int numCourses = 2;
//        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites = {{0, 1},{1,0}};
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return usingCycleDetectionMethod(numCourses, prerequisites);
    }

    private int[] usingCycleDetectionMethod(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjMatrix = getAdjMatrix(numCourses, prerequisites);
        List<Integer> res = new ArrayList<>();
//        System.out.println(adjMatrix);
        int[] visited = new int[numCourses];
        int[] circleFormed = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (findOrderDFS(i, visited, circleFormed, res, adjMatrix)) return new int[0];
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean findOrderDFS(int node, int[] visited, int[] circleFormed, List<Integer> res, List<List<Integer>> adjMatrix) {
        visited[node] = 1;
        circleFormed[node] = 1;
        for (int element : adjMatrix.get(node)) {
            if(visited[element] == 0) {
                if (findOrderDFS(element, visited, circleFormed, res, adjMatrix)) return true;
            } else if (circleFormed[element] == 1) return true;
        }
        circleFormed[node] = 0;
        res.add(node);
        return false;
    }

    private List<List<Integer>> getAdjMatrix(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            adjMatrix.get(from).add(to);
        }
        return adjMatrix;
    }
}
