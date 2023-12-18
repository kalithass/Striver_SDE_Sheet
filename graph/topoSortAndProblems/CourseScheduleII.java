package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/course-schedule-ii_1069243
public class CourseScheduleII implements App {
    @Override
    public void run() {
        int v = 2;
//        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites = {{0, 1},{0,1}};
        List<List<Integer>> mat = new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++) {
            List<Integer> list = new ArrayList<>();
            for(int element : prerequisites[i]) {
                list.add(element);
            }
            mat.add(list);
        }
        List res = findSchedule(2, mat);
        System.out.println(res);
    }

    public static List<Integer> findSchedule(int numCourses, List<List<Integer>> prerequisites) {
        int m = numCourses+1;
        List<List<Integer>> adjMatrix = getAdjMatrix(m, prerequisites);
        List<Integer> res = new ArrayList<>();
        int[] degreeMatrix = new int[m];
        fillDegreesNodes(adjMatrix, degreeMatrix);
        populateResult(adjMatrix, degreeMatrix, res);
        // length equals means no cycle
        return res.size() == numCourses ? res : new ArrayList<>();
    }

    private static void populateResult(List<List<Integer>> adjMatrix, int[] degreeMatrix, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degreeMatrix.length;i++) {
            if(degreeMatrix[i] == 0) {
                queue.add(i);
                res.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            for(int element : adjMatrix.get(val)) {
                degreeMatrix[element]--;
                if(degreeMatrix[element] == 0) {
                    res.add(element);
                    queue.add(element);
                }
            }
        }
    }

    private static void fillDegreesNodes(List<List<Integer>> adjMatrix, int[] degreeMatrix) {
        for(List<Integer> node : adjMatrix) {
            for(int element: node ) {
                degreeMatrix[element]++;
            }
        }
    }

    private static List<List<Integer>> getAdjMatrix(int numCourses, List<List<Integer>> edges) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (List<Integer> prerequisite : edges) {
            int from = prerequisite.get(0);
            int to = prerequisite.get(1);
            adjMatrix.get(from).add(to);
        }
        return adjMatrix;
    }
}
