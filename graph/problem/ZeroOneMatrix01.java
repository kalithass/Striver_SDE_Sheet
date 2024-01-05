package strivers.graph.problem;

import strivers.App;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//https://leetcode.com/problems/01-matrix/description/
public class ZeroOneMatrix01 implements App {

    @Override
    public void run() {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] res = updateMatrix(grid);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visitedMatrix = new int[n][m];
        int[][] res = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    visitedMatrix[i][j] = 1;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }

        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            int len = arr[2];
            res[row][col] = len;
            for (int i = 0; i < 4; i++) {
                int x = row + rowIncrement[i];
                int y = col + colIncrement[i];
                if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && visitedMatrix[x][y] == 0) {
                    visitedMatrix[x][y] = 1;
                    queue.add(new int[]{x, y, len + 1});
                }
            }
        }
        return res;
    }
}
