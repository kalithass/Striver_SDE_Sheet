package strivers.graph.problem;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-enclaves/
public class NumberOfEnclaves implements App {

    @Override
    public void run() {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        };
        int res = numEnclaves(grid);
        System.out.println(res);
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visitedMatrix = new int[n][m];

        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, 1, -1};

        for (int col = 0; col < m; col++) {
            if (visitedMatrix[0][col] == 0 && grid[0][col] == 1)
                dfs(visitedMatrix, grid, 0, col, rowIncrement, colIncrement);
            if (visitedMatrix[n - 1][col] == 0 && grid[n - 1][col] == 1)
                dfs(visitedMatrix, grid, n - 1, col, rowIncrement, colIncrement);
        }

        for (int row = 0; row < n; row++) {
            if (visitedMatrix[row][0] == 0 && grid[row][0] == 1)
                dfs(visitedMatrix, grid, row, 0, rowIncrement, colIncrement);
            if (visitedMatrix[row][m - 1] == 0 && grid[row][m - 1] == 1)
                dfs(visitedMatrix, grid, row, m - 1, rowIncrement, colIncrement);
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (visitedMatrix[i][j] == 0 && grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int[][] visitedMatrix, int[][] grid, int row, int col, int[] rowIncrement, int[] colIncrement) {
        visitedMatrix[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int x = row + rowIncrement[i];
            int y = col + colIncrement[i];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                    && visitedMatrix[x][y] == 0 && grid[x][y] == 1) {
                visitedMatrix[x][y] = 1;
                dfs(visitedMatrix, grid, x, y, rowIncrement, colIncrement);
            }
        }
    }
}
