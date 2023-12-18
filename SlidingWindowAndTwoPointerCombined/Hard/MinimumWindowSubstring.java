package strivers.SlidingWindowAndTwoPointerCombined.Hard;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring implements App {

    @Override
    public void run() {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        return usingMap(s, t);
//        return withoutMap(s, t); // n * 26
    }

    private String usingMap(String s, String t) {
        int start = 0;
        int end = s.length();
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        int count = t.length();

        for(int right = 0; right<s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                if(map.get(s.charAt(right)) > 0) count--;
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
            }

            while (count == 0) {
                if(right-left <= end-start) {
                    start = left;
                    end = right;
                }
                if (map.containsKey(s.charAt(left))) {
                    if(map.get(s.charAt(left)) == 0) count++;
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                }
                left++;
            }
        }
        if (end == s.length()) return "";
        return s.substring(start, end + 1);
    }

    private String withoutMap(String s, String t) {
        int[] arrt = new int[52];
        for (int i = 0; i < t.length(); i++) {
            arrt[getIndex(t.charAt(i))]++;
        }

        int[] arrs = new int[52];
        int left = 0;
        int start = 0, end = s.length();
        for (int right = 0; right < s.length(); right++) {
            arrs[getIndex(s.charAt(right))]++;
            while (left <= right && isPresent(arrs, arrt)) {
                arrs[getIndex(s.charAt(left))]--;
                if (right - left <= end - start) {
                    start = left;
                    end = right;
                }
                left++;
            }
        }
        if (end == s.length()) return "";
        return s.substring(start, end + 1);
    }

    private int getIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return ch - 'A' + 26;
    }

    boolean isPresent(int[] s, int[] t) {
        for (int i = 0; i < 52; i++) if (s[i] < t[i]) return false;
        return true;
    }
}