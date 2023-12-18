package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://www.codingninjas.com/studio/problems/floyd-warshall_2041979
public class FloydWarshall implements App {

    @Override
    public void run() {
//        int[][] mat = {
//                {1, 2, 2},
//                {1, 3, 2},
//                {2, 3, -1},
//        };
//        int n = 3;
//        int m = 3;
//        int src = 1;
//        int dst = 3;
        int[][] mat = {
                {2, 1, 3},
//                {1, 3, 2},
//                {2, 3, -1},
        };
        int n = 2;
        int m = 1;
        int src = 1;
        int dst = 2;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int[] arr : mat) {
             ArrayList<Integer> list = new ArrayList<>();
             for(int element : arr) list.add(element);
             edges.add(list);
        }
        int res = floydWarshall(n, m, src, dst, edges);
        System.out.println(res);
    }

    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[][] adjMat = getAdjacencyArr(edges, n, m);
//        for (int[] ints : adjMat) {
//            System.out.println(Arrays.toString(ints));
//        }
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(adjMat[i][k] == Integer.MAX_VALUE || adjMat[k][j] == Integer.MAX_VALUE) continue;
                    adjMat[i][j] = Math.min(adjMat[i][j],
                            adjMat[i][k] + adjMat[k][j]);
                }
            }
//            printAdjMat(adjMat);
        }


        return adjMat[src][dest] != Integer.MAX_VALUE ? adjMat[src][dest] : (int)1e9;
    }

    private static void printAdjMat(int[][] adjMat) {
        for (int[] ints : adjMat) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    private static int[][] getAdjacencyArr(ArrayList<ArrayList<Integer>> edges, int n, int m) {
        int[][] mat = new int[n+1][n+1];
        for(int[] ar : mat) Arrays.fill(ar, Integer.MAX_VALUE);
        for(int i=0;i<m;i++) {
            int from = edges.get(i).get(0);
            int to = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            mat[from][to] = weight;
        }
        for(int i=1;i<=n;i++) mat[i][i] = 0;
        return mat;
    }

}
