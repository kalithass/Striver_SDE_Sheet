package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
public class FindTheCityWithTheSmallestNumberOfNeighborsAtaThresholdDistance implements App {

    @Override
    public void run() {

//        int[][] edges = {
//                {0, 1, 2},
//                {0, 4, 8},
//                {1, 2, 3},
//                {1, 4, 2},
//                {2, 3, 1},
//                {3, 4, 1}
//        };
        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1},
        };
        int n = 4;
        int distanceThreshold = 4;
        int res = findTheCity(n, edges, distanceThreshold);
        System.out.println(res);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = getAdjacencyArr1(edges, n);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE) continue;
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j],
                            adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        int maxCountSoFar = Integer.MAX_VALUE;
        int cityNumber = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] <= distanceThreshold)
                    count++;
            }

            if (count <= maxCountSoFar) {
                maxCountSoFar = count;
                cityNumber = i;
            }
        }
        return cityNumber;
    }

    private int[][] getAdjacencyArr1(int[][] edges, int n) {
        int[][] mat = new int[n][n];
        for (int[] arr : mat) Arrays.fill(arr, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            mat[from][to] = weight;
            mat[to][from] = weight;
        }

        for (int i = 0; i < n; i++) mat[i][i] = 0;
        return mat;
    }

    private static void printAdjMat(int[][] adjMat) {
        for (int[] ints : adjMat) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
