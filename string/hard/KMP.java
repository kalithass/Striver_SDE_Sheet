package strivers.string.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/768242242/
public class KMP implements App {

    @Override
    public void run() {
        String text = "axyzcdxyz";
        String pattern = "xyz";
        List<Integer> res = getAllTheIndex(text, pattern);
//        int res = strStr(text, pattern);
        System.out.println(res);
    }

    private List<Integer> getAllTheIndex(String haystack, String needle) {
        List<Integer> res = new ArrayList<>();
        int[] lps = constructLps(needle);
        int i = 0;
        int n = haystack.length();
        int j = 0;
        while (i<n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if(j == 0) i++;
                else j = lps[j-1];
            }
            if(j == needle.length()) {
                res.add(i - needle.length());
            }
        }
        return res;
    }

    public int strStr(String haystack, String needle) {
        int[] lps = constructLps(needle);
        int i = 0;
        int n = haystack.length();
        int j = 0;
        while (i<n) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if(j == 0) i++;
                else j = lps[j-1];
            }
            if(j == needle.length()) return i - needle.length();
        }
        return -1;
    }

    private int[] constructLps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int left = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(left) == s.charAt(i)) {
                lps[i] = left +1;
                left++;
                i++;
            } else {
                if(left == 0) {
                    i++;
                } else {
                    left = lps[left-1];
                }
            }
        }
        return lps;
    }
}
