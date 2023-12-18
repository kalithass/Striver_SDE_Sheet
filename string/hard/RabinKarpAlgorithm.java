package strivers.string.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/stringmatch-rabincarp_1115738
public class RabinKarpAlgorithm implements App {

    @Override
    public void run() {
        String text = "kjujqutshmhmwkhsuovaljpnndrqtvshkjxtgafe";
        String pattern = "ljpnndrqtvshkjxtgafe";
        List<Integer> res = stringMatch(text, pattern);
        System.out.println(res);
    }


    public static List<Integer> stringMatch(String text, String pattern) {
//        return usingRabinKarp(text, pattern);
        return usingKMP(text, pattern);
    }

    private static List<Integer> usingKMP(String haystack, String needle) {
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
                j = lps[j-1];
            }
        }
        return res;
    }

    private static int[] constructLps(String s) {
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

    private static List<Integer> usingRabinKarp(String text, String pattern) {
        List<Integer> res = new ArrayList<>();
        if (text.length() < pattern.length()) return res;
        int mod = 1000000;
        int pLen = pattern.length();
        int pow = 1;
        int patternHash = 0;
        int rollingHash = 0;
        for (int i = 0; i < pLen; i++) {
            patternHash = (patternHash * 26 + pattern.charAt(i)) % mod;
            rollingHash = (rollingHash * 26 + text.charAt(i)) % mod;
            pow = (pow * 26) % mod;
        }

        for (int i = pLen - 1; i < text.length(); i++) {
            if (i >= pLen) {
                rollingHash = (rollingHash * 26 + text.charAt(i)) % mod;
                rollingHash = (rollingHash - text.charAt(i-pLen) * pow) % mod;
            }
            if(rollingHash < 0) rollingHash += mod;
            if (rollingHash == patternHash && (matchStrings(text, pattern, i))) {
                res.add(i-pLen+1 + 1);
            }
        }

        return res;
    }

    private static boolean matchStrings(String text, String pattern, int ind) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(ind - pattern.length() + 1 + i) != pattern.charAt(i)) return false;
        }
        return true;
    }
}
