package strivers.BitManipulation.learning;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/check-whether-k-th-bit-is-set-or-not_5026446
public class CheckIfIthBitSet implements App {

    @Override
    public void run() {
        int num = 3;
        int k = 2;
        boolean res = isKthBitSet(num, k);
        System.out.println(res);
    }

    static boolean isKthBitSet(int n, int k) {
        k--;
        System.out.println();
        return (n & (1<<k)) != 0;
    }
}
