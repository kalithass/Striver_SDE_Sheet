package strivers.recursion.getastronghold;

import strivers.App;

//https://leetcode.com/problems/count-good-numbers/
public class CountGoodNumbers implements App {

    @Override
    public void run() {
        long n = 8;
        double res = countGoodNumbers(n);
        System.out.println(res);
    }

    /*
        if n =5, 0 1 2 3 4 => 3 even and 4 odd,
        at each even index 5 elements possible (0,2,4,6,8)
        at each odd index 4 elements possible (2,3,5,7)
        if n =2, 5 * 4
        if n =3, 5 * 4 * 5
        if n =4, 5 * 4 * 5 * 4
        if n =5, 5 * 4 * 5 * 4 * 5
        hence for n,
        if n is even, res = 5 pow (n/2) * 4 pow (n/2)
        if n is odd, res = 5 pow (n/2) * 4 pow (n/2) * 5
     */
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long evenPosition = pow(5, n/2, mod);
        long oddPosition = pow(4, n/2, mod);
        long res = (evenPosition * oddPosition) % mod;
        if(n%2 == 1) res = (res*5) % mod;
        return (int)res;
    }

    long pow(long x, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                x = (x * x) % mod;
                n /= 2;
            } else {
                res = (x * res) % mod;
                n--;
            }
        }
        return res % mod;
    }
}
