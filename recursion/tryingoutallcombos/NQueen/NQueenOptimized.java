package strivers.recursion.tryingoutallcombos.NQueen;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class NQueenOptimized implements App {

    @Override
    public void run() {
        int n = 5;
        List<List<String>> res = solveNQueens(n);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] ch = new char[n][n];
        boolean[] columnChecker = new boolean[n];
        boolean[] leftDiagonalChecker = new boolean[2*n-1];
        boolean[] rightDiagonalChecker = new boolean[2*n-1];
        nQueensHelper(ch, 0, n, res, columnChecker, rightDiagonalChecker, leftDiagonalChecker);
        return res;
    }

    private void nQueensHelper(char[][] ch, int row, int n, List<List<String>> res, boolean[] columnChecker, boolean[] rightDiagonalChecker, boolean[] leftDiagonalChecker) {
        if(row == n) {
            addToResult(res, ch);
            return;
        }

        for (int col=0;col<n;col++) {
            if (isQueenCanBePlaced(columnChecker, leftDiagonalChecker, rightDiagonalChecker,row, col, n)) {
                updateQueenPosition(columnChecker, leftDiagonalChecker, rightDiagonalChecker, row, col, true, n);
                ch[row][col] = 'Q';

                nQueensHelper(ch, row+1, n, res, columnChecker, rightDiagonalChecker, leftDiagonalChecker);

                ch[row][col] = '.';
                updateQueenPosition(columnChecker, leftDiagonalChecker, rightDiagonalChecker, row, col, false, n);
            }
        }
    }

    private void updateQueenPosition(boolean[] columnChecker, boolean[] leftDiagonalChecker,
                                     boolean[] rightDiagonalChecker, int row,
                                     int col, boolean isSet, int n) {
        columnChecker[col] = isSet;
        leftDiagonalChecker[n-row+col-1] = isSet;
        rightDiagonalChecker[row+col] = isSet;
    }

    private boolean isQueenCanBePlaced(boolean[] columnChecker, boolean[] leftDiagonalChecker,
                                       boolean[] rightDiagonalChecker, int row, int col, int n) {
        return !columnChecker[col] && !leftDiagonalChecker[n-row+col-1] && !rightDiagonalChecker[row+col];
    }

    private void addToResult(List<List<String>> res, char[][] ch) {
        int n = ch.length;
        List<String> list = new ArrayList<>();
        for (char[] chars : ch) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (chars[j] == 'Q') sb.append('Q');
                else sb.append('.');
            }
            list.add(sb.toString());
        }
        res.add(list);
    }

}
