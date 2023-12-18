package strivers.SlidingWindowAndTwoPointerCombined.Hard;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://www.codingninjas.com/studio/problems/longest-substring-with-at-most-k-distinct-characters_2221410
public class LongestSubstringAtMostKDistance implements App {

    @Override
    public void run() {
        String s = "abbbbbbc";
        int k = 2;
        int res = kDistinctChars(k, s);
        System.out.println(res);
    }

    public static int kDistinctChars(int k, String str) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<str.length(); right++ ) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
            while (left<=right && map.size() > k) {
                map.put(str.charAt(left), map.get(str.charAt(left))-1);
                map.remove(str.charAt(left), 0);
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
