package strivers.recursion.tryingoutallcombos.NQueen;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class NQueen implements App {

    @Override
    public void run() {
        int n = 5;
        List<List<String>> res = solveNQueens(n);
        System.out.println(res);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] ch = new char[n][n];
        nQueensHelper(ch, 0, n, res);
        return res;
    }

    private void nQueensHelper(char[][] ch, int row, int n, List<List<String>> res) {
        if(row == n) {
            addToResult(res, ch);
            return;
        }

        for (int col=0;col<n;col++) {
            if (queenCanBePlaced(ch, row, col)) {
                ch[row][col] = 'Q';
                nQueensHelper(ch, row+1, n, res);
                ch[row][col] = '.';
            }
        }
    }


    private boolean queenCanBePlaced(char[][] ch, int row, int col) {
        for(int r = row; r >= 0; r--) {
            if(ch[r][col] == 'Q') return false;
        }

        int r = row, c = col;
        while (r>=0 && c>=0) {
            if (ch[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while (r>=0 && c>=0) {
            if (ch[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r >=0 && c <ch.length) {
            if (ch[r][c] == 'Q') return false;
            r--;
            c++;
        }
        return true;
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
