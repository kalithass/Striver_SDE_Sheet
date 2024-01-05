package strivers.graph.problem;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions  implements App {

    @Override
    public void run() {
        char[][] grid = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(grid);
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }


    // set visited matrix as 1 which can be reached from 4 ends of '0'
    // assign mat[i][j] as 'X' if vis[i][j] = 0 // which means it cannot be reached from border '0'

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visitedMatrix = new int[n][m];
        int[] rowIncrement = {1, -1, 0, 0};
        int[] colIncrement = {0, 0, 1, -1};

        for (int col = 0; col < m; col++) {
            if (visitedMatrix[0][col] == 0 && board[0][col] == 'O') dfs(visitedMatrix, board, 0, col, rowIncrement, colIncrement);
            if (visitedMatrix[n - 1][col] == 0 && board[n-1][col] == 'O') dfs(visitedMatrix, board, n - 1, col, rowIncrement, colIncrement);
        }

        for (int row = 0; row < n; row++) {
            if (visitedMatrix[row][0] == 0 && board[row][0] == 'O') dfs(visitedMatrix, board, row, 0, rowIncrement, colIncrement);
            if (visitedMatrix[row][m - 1] == 0 && board[row][m-1] == 'O') dfs(visitedMatrix, board, row, m - 1, rowIncrement, colIncrement);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visitedMatrix[i][j] == 0) board[i][j] = 'X';
            }
        }

//        for(int[] row : visitedMatrix) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
    }

    private void dfs(int[][] visitedMatrix, char[][] board, int row, int col,
                     int[] rowIncrement, int[] colIncrement) {
        visitedMatrix[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int x = row + rowIncrement[i];
            int y = col + colIncrement[i];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length
                    &&visitedMatrix[x][y]==0 && board[x][y] == 'O') {
                visitedMatrix[x][y] = 1;
                dfs(visitedMatrix, board, x, y, rowIncrement, colIncrement);
            }
        }
    }
}
