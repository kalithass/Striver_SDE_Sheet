package strivers.string.hard;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/shortest-palindrome/
public class ShortestPalindrome implements App {

    @Override
    public void run() {
        String s = "abbaxy";
        String res = shortestPalindrome(s);
        System.out.println(res);
    }


    //    https://www.youtube.com/watch?v=sy-jwlCETfw
    public String shortestPalindrome(String s) {
        String temp = new StringBuilder(s).append('#').append(new StringBuilder(s).reverse()).toString();
        int[] lps = constructLps(temp);
        StringBuilder res = new StringBuilder();
        for (int i=s.length()-1;i>=lps[temp.length()-1];i--) {
            res.append(s.charAt(i));
        }
        res.append(s);
        return res.toString();
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
