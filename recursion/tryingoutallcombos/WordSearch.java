package strivers.recursion.tryingoutallcombos;

import strivers.App;

//https://leetcode.com/problems/word-search/
public class WordSearch implements App {

    @Override
    public void run() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}};
        String word = "ABCCEDE";
        boolean res = exist(board, word);
        System.out.println(res);
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visitedMatrix = new boolean[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (recursiveHelper(board, i, j, visitedMatrix, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean recursiveHelper(char[][] board, int row, int col, boolean[][] visitedMatrix, String word, int i) {
        if (i == word.length()) return true;
        if (row == -1 || col == -1 || row == board.length || col == board[0].length) return false;
        boolean left, top, right, bottom;
        if (!visitedMatrix[row][col] && word.charAt(i) == board[row][col]) {
            visitedMatrix[row][col] = true;

            left = recursiveHelper(board, row, col - 1, visitedMatrix, word, i + 1);
            if (left) return true;

            top = recursiveHelper(board, row - 1, col, visitedMatrix, word, i + 1);
            if (top) return true;

            right = recursiveHelper(board, row, col + 1, visitedMatrix, word, i + 1);
            if (right) return true;

            bottom = recursiveHelper(board, row + 1, col, visitedMatrix, word, i + 1);
            if (bottom) return true;

            visitedMatrix[row][col] = false;
        }
        return false;
    }
}
