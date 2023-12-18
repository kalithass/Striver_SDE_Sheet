package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
public class SubstringsContainingAllThreeCharacters implements App {

    @Override
    public void run() {
        String s = "abc";
        int res = numberOfSubstrings(s);
        System.out.println(res);
    }

    public int numberOfSubstrings(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (left <= right && containsAllThree(map)) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                map.remove(s.charAt(left), 0);
                res += s.length() - right;
                left++;
            }
        }

        return res;
    }

    private boolean containsAllThree(Map<Character, Integer> map) {
        return map.containsKey('a') && map.containsKey('b') && map.containsKey('c');
    }
}


/*
        a a b c c c c c  ->

        a a b c
        a a b c c
        a a b c c c
        a a b c c c c
        a a b c c c c c

        a b c
        a b c c
        a b c c c
        a b c c c c
        a b c c c c c
 */