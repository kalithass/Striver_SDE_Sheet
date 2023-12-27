package strivers.recursion.tryingoutallcombos;

import strivers.App;

//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver implements App {

    @Override
    public void run() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        printBoard(board);
    }

    private void printBoard(char[][] board) {
        for (char[] arr : board) {
            for (char ch : arr) System.out.print(ch+" ");
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        recursiveHelper(board, board.length, 0, 0);
    }

    private boolean recursiveHelper(char[][] board, int n, int row, int col) {
        if (col == n) {
            row++;
            col = 0;
        }
        if (row == n) return true;
        if (board[row][col] != '.') return recursiveHelper(board, n, row, col + 1);
        else {
            for (char i = '1'; i <= '9'; i++) {
                if (canBePlaced(board, row, col, i)) {
                    board[row][col] = i;
                    if (recursiveHelper(board, n, row, col + 1)) return true;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private boolean canBePlaced(char[][] board, int row, int col, char value) {
        // row check
        for (int i = 8; i >= 0; i--) {
            if (board[row][i] == value) return false;
        }

        // column check
        for (int i = 8; i >= 0; i--) {
            if (board[i][col] == value) return false;
        }

        // box check
        int bigRow = row / 3;
        int bigCol = col / 3;
        for (int i = 0; i < 3; i++) {
            int currentRow = (bigRow * 3) + i;
            for (int j = 0; j < 3; j++) {
                int currentCol = (bigCol * 3) + j;
                if (board[currentRow][currentCol] == value) return false;
            }
        }

        return true;
    }
}
