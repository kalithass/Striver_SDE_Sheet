package strivers.string.hard;

import strivers.App;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/longest-happy-prefix/
public class LongestHappyPrefix implements App {

    @Override
    public void run() {
        String s = "ababab";
        String res = longestPrefix(s);
        System.out.println(res);
    }

    public String longestPrefix(String s) {
        int[] lps = constructLps(s);
//        System.out.println(Arrays.toString(lps));
        return s.substring(0, lps[s.length()-1]);
    }

    private int[] constructLps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1;
        int left = 0;
        while (i < n) {
            if(s.charAt(left) == s.charAt(i)) {
                lps[i] = left+1;
                left++;
                i++;
            } else {
                if(left == 0) {
                    i++;
                }
                else {
                    left = lps[left-1];
                }
            }
        }
        return lps;
    }
}
