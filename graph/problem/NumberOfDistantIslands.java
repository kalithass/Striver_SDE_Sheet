package strivers.graph.problem;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/distinct-islands_630460
public class NumberOfDistantIslands implements App {
    @Override
    public void run() {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int res = distinctIsland(mat, mat.length, mat[0].length);
        System.out.println(res);
    }

    public static int distinctIsland(int [][] arr, int n, int m)
    {
        Set<List<List<Integer>>> shapeSet = new HashSet<>();
        boolean[][] visitedMatrix = new boolean[n][m];
        int[] rowIncrement = {-1, 1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedMatrix[i][j] && arr[i][j] == 1) {
                    ArrayList<List<Integer>> list = new ArrayList<>();
//                    list.add(List.of(i,j));
                    dfs(arr, visitedMatrix, i, j, rowIncrement, colIncrement, list, i, j);
                    shapeSet.add(list);
                }
            }
        }
        // System.out.println(shapeSet);
        return shapeSet.size();
    }

    private static void dfs(int[][] arr, boolean[][] visitedMatrix, int r, int c, int[] rowIncrement,
                            int[] colIncrement, ArrayList<List<Integer>> list, int br, int bc) {
        visitedMatrix[r][c] = true;
        list.add(new ArrayList<>(Arrays.asList(r - br, c - bc)));
        for (int i = 0; i < 4; i++) {
            int x = r + rowIncrement[i];
            int y = c + colIncrement[i];
            if (x >= 0 && y >= 0 && x < arr.length && y < arr[0].length
                    && !visitedMatrix[x][y] && arr[x][y] == 1) {
                dfs(arr, visitedMatrix, x, y, rowIncrement, colIncrement, list, br, bc);
            }
        }
    }
}
