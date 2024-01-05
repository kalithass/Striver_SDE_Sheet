package strivers.graph.problem;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/flood-fill/description/
public class FloodFill  implements App {

    @Override
    public void run() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] res = floodFill(grid,1,1,2 );
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        if(image[sr][sc] == color) return image;
        int[][] visitedMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(image[i], 0, visitedMatrix[i], 0, m);
        }

        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, 1, -1};

        // dfs
        fillTheFlood(visitedMatrix, sr, sc, color, visitedMatrix[sr][sc], rowIncrement, colIncrement);
        return visitedMatrix;
    }

    private void fillTheFlood(int[][] visitedMatrix, int sr, int sc, int color, int colorToBeChanged, int[] rowIncrement, int[] colIncrement) {
        int n = visitedMatrix.length;
        int m = visitedMatrix[0].length;


        visitedMatrix[sr][sc] = color;
        for (int i = 0; i < 4; i++) {
            int x = sr + rowIncrement[i];
            int y = sc + colIncrement[i];
            if (x >= 0 && y >= 0 && x < n && y < m && visitedMatrix[x][y] == colorToBeChanged) {
                visitedMatrix[x][y] = color;
                fillTheFlood(visitedMatrix, x, y, color, colorToBeChanged, rowIncrement, colIncrement);
            }
        }

    }
}
