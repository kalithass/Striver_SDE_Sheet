package strivers.BitManipulation.learning;

import strivers.App;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoNumbers implements App {

    @Override
    public void run() {
        int a = -2147483648;
        int b = 1;
        int res = divide(a, b);
        System.out.println(res);
    }

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor ==-1) return Integer.MAX_VALUE;
        int sign = (dividend>=0  == divisor>=0) ? 1 : -1;
        int ans = 0;
        dividend = Math.abs(dividend);
        divisor  =  Math.abs(divisor);
        while (dividend - divisor >= 0) {
            int count = 1;
            int temp = divisor;
            while (dividend - (temp<<1) >= 0) {
                temp = temp<<1;
                count = count<<1;
            }
            ans += count;
            dividend = dividend - temp;
        }
        return ans*sign;
    }
}

// 100000000000000000000000000000