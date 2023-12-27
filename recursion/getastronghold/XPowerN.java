package strivers.recursion.getastronghold;

import strivers.App;

//https://leetcode.com/problems/powx-n/
public class XPowerN implements App {

    @Override
    public void run() {
        double res = myPow(2,10);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        return iterativeHelper(x,n);
        // return recursiveHelper(x, n);
    }

    // 2 pow 9 => 2 * rec(8)
    // 2 pow 8 => rec(4, 4)
    private double recursiveHelper(double x, double n) {
        if(n == 0) return 1;
        if(n < 0) {
            n = Math.abs(n);
            x = 1/x;
        }
        if (n%2 == 0) return recursiveHelper(x*x, n/2);
        return x*recursiveHelper(x, n-1);
    }

    private double iterativeHelper(double x, double n) {
        if(n < 0) {
            n = Math.abs(n);
            x = 1/x;
        }
        double res = 1;
        double mod = 1000000007;
        while(n>0) {
            if(n%2 == 1) {
                res = (res*x) % mod;
                n--;
            } else {
                x = (x*x) % mod;
                n/=2;
            }
        }
        return res % mod;
    }
}
