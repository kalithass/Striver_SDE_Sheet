package strivers.graph.problem;

import strivers.App;
import strivers.Main;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges implements App {

    @Override
    public void run() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int res = orangesRotting(grid);
        System.out.println(res);
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // copy of the gird
        int[][] rottenMatrix = new int[n][m];
        Queue<Container> queue = getRottenQueue(grid, n, m, rottenMatrix);

        int[] rowMatrix = {-1, 1, 0, 0};
        int[] colMatrix = {0, 0, -1, 1};

        int res = getTimeToRotAllTheOranges(n, m, rottenMatrix, queue, rowMatrix, colMatrix);

        for (int[] rows : rottenMatrix) {
            for (int j = 0; j < m; j++) {
                if (rows[j] == 1) return -1;
            }
        }

        return res;
    }

    private static int getTimeToRotAllTheOranges(int n, int m, int[][] rottenMatrix, Queue<Container> queue, int[] rowMatrix, int[] colMatrix) {
        int res = 0;
        while (!queue.isEmpty()) {
            Container temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            int time = temp.time;
            res = Math.max(res, time);

            for (int i=0;i<4;i++) {
                int currRow = row + rowMatrix[i];
                int currCol = col + colMatrix[i];
                if (currRow>=0 && currRow< n && currCol>=0 && currCol< m) {
                    if (rottenMatrix[currRow][currCol] == 1) {
                        rottenMatrix[currRow][currCol] = 2;
                        queue.add(new Container(currRow, currCol, time+1));
                    }
                }
            }
        }

        return res;
    }

    private Queue<Container> getRottenQueue(int[][] grid, int n, int m, int[][] rottenMatrix) {
        Queue<Container> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) queue.add(new Container(i, j, 0));
                rottenMatrix[i][j] = grid[i][j];
            }
        }
        return queue;
    }

    static class Container {
        int row;
        int col;
        int time;

        public Container(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
