package strivers.dp.MCM;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/boolean-evaluation_1214650
public class EvaluateExp implements App {

    @Override
    public void run() {
        String exp = "T^T^F";
        int res = evaluateExp(exp);
        System.out.println(res);
    }

    public static int evaluateExp(String exp) {
        return recursiveApproach(exp);
    }

    private static int recursiveApproach(String exp) {
        int n = exp.length();
        long[][][] dp = new long[n][n][2];
        for (long[][] mat : dp) for (long[] row : mat) Arrays.fill(row, -1);
        return (int)recursiveHelper(exp, 0, n-1, 1, dp);
    }

    // isTrue -> 1- true needed, 0 - false needed
    private static long recursiveHelper(String exp, int i, int j, int isTrue, long[][][] dp) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue == 1) {
                if (exp.charAt(i) == 'T') return 1;
            } else {
                if (exp.charAt(i) == 'F') return 1;
            }
            return 0;
        }
        int mod = 1000000007;
        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        long res = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            long leftTrue = recursiveHelper(exp, i, k - 1, 1, dp);
            long leftFalse = recursiveHelper(exp, i, k - 1, 0, dp);
            long rightTrue = recursiveHelper(exp, k + 1, j, 1, dp);
            long rightFalse = recursiveHelper(exp, k + 1, j, 0, dp);
            char ch = exp.charAt(k);
            if (ch == '&') {
                if (isTrue == 1) res = (res + (leftTrue * rightTrue) % mod) % mod;
                else
                    res = (res + ((leftFalse * rightTrue) % mod) + ((leftTrue * rightFalse) % mod) + ((leftFalse * rightFalse) % mod)) % mod;
            } else if (ch == '|') {
                if (isTrue == 1)
                    res = (res + (leftFalse * rightTrue) % mod) + ((leftTrue * rightFalse) % mod) + ((leftTrue * rightTrue) % mod);
                else res = (res + (leftFalse * rightFalse)) % mod;
            } else if (ch == '^') {
                if (isTrue == 1) res = (res + ((leftFalse * rightTrue) % mod) + ((leftTrue * rightFalse) % mod)) % mod;
                else res = (res + ((leftFalse * rightFalse) % mod) + ((leftTrue * rightTrue) % mod)) % mod;
            }
        }
        return dp[i][j][isTrue] = res%mod;
    }
}
