package strivers.BitManipulation.advancedMaths;

import strivers.App;

import java.util.List;

//https://leetcode.com/problems/powx-n/
public class XpowerN implements App {

    @Override
    public void run() {
        double x = 2.10000;
        int n = 3;
        double res = myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        return recHelper(x, n);
    }

    private double recHelper(double x, double n) {
        if (n == 0) return 1;
        if (n < 0) {
            n = Math.abs(n);
            x = 1 / x;
        }
        if (n % 2 == 0) {
            return recHelper(x * x, n / 2);
        } else {
            return x * recHelper(x, n - 1);
        }
    }
}
