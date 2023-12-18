package strivers.BitManipulation.InterviewProblems;

import strivers.App;

//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
public class CountNumberOfBitsToBeFlipped implements App {

    @Override
    public void run() {
        int a = 10;
        int b = 7;
        int res = minBitFlips(a, b);
        System.out.println(res);
    }

    public int minBitFlips(int start, int goal) {
        int val = start ^ goal;

        // nothing that much of an optimization
        if(val == 0) return 0;

        int count = 0;
        while(val > 0) {
            val = val & (val-1);
            count++;
        }
        return count;
    }
}
