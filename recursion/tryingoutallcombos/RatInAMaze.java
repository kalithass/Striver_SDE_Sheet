package strivers.recursion.tryingoutallcombos;

import strivers.App;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze implements App {

    @Override
    public void run() {
        int[][] m = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        int n = m.length;
        ArrayList<String> res = findPath(m, n);
        System.out.println(res);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visitedMatrix = new boolean[n][n];
        ArrayList<String > res = new ArrayList<>();
        if (m[0][0] == 0 || m[n-1][n-1] == 0) {
            res.add("-1");
            return res;
        }
        recursiveHelper(res, "", 0, 0, n, m, visitedMatrix);
        return res;
    }

    private static void recursiveHelper(ArrayList<String> res, String s, int row, int col, int n, int[][] m, boolean[][] visitedMatrix) {
        if (row == n-1 && col == n-1) {
            res.add(s);
            return;
        }

        // down
        if(row+1 < n && m[row+1][col] == 1 && !visitedMatrix[row+1][col]) {
            visitedMatrix[row][col] = true;
            recursiveHelper(res, s+"D", row+1, col, n, m, visitedMatrix);
            visitedMatrix[row][col] = false;
        }

        // left
        if(col-1>=0 && m[row][col-1] == 1 && !visitedMatrix[row][col-1]) {
            visitedMatrix[row][col] = true;
            recursiveHelper(res, s+"L", row, col-1, n, m, visitedMatrix);
            visitedMatrix[row][col] = false;
        }

        // right
        if(col+1 < n && m[row][col+1] == 1 && !visitedMatrix[row][col+1]) {
            visitedMatrix[row][col] = true;
            recursiveHelper(res, s+"R", row, col+1, n, m, visitedMatrix);
            visitedMatrix[row][col] = false;
        }

        // up
        if(row-1>=0 && m[row-1][col] == 1 && !visitedMatrix[row-1][col]) {
            visitedMatrix[row][col] = true;
            recursiveHelper(res, s+"U", row-1, col, n, m, visitedMatrix);
            visitedMatrix[row][col] = false;
        }
    }
}
