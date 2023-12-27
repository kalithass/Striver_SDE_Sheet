package strivers.recursion.tryingoutallcombos.NQueen;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens-ii/
public class NQueenII  implements App {

    @Override
    public void run() {
        int n = 4;
        int res = totalNQueens(n);
        System.out.println(res);
    }

    public int totalNQueens(int n) {
        boolean[] columnChecker = new boolean[n];
        boolean[] leftDiagonalChecker = new boolean[2*n-1];
        boolean[] rightDiagonalChecker = new boolean[2*n-1];
        return nQueensHelper(0, n, columnChecker, rightDiagonalChecker, leftDiagonalChecker);
    }

    private int nQueensHelper(int row, int n, boolean[] columnChecker, boolean[] rightDiagonalChecker, boolean[] leftDiagonalChecker) {
        int res = 0;
        if(row == n) return 1;

        for (int col=0;col<n;col++) {
            if (isQueenCanBePlaced(columnChecker, leftDiagonalChecker, rightDiagonalChecker,row, col, n)) {
                updateQueenPosition(columnChecker, leftDiagonalChecker, rightDiagonalChecker, row, col, true, n);
                res += nQueensHelper( row+1, n, columnChecker, rightDiagonalChecker, leftDiagonalChecker);
                updateQueenPosition(columnChecker, leftDiagonalChecker, rightDiagonalChecker, row, col, false, n);
            }
        }
        return res;
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
        return !columnChecker[col] && !leftDiagonalChecker[n - row + col - 1] && !rightDiagonalChecker[row + col];
    }
}
