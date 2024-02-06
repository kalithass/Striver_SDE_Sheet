package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters implements App {

    @Override
    public void run() {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        while (right<n) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                res  = Math.max(set.size(), res);
                right++;
            }
            else {
            set.remove(s.charAt(left));
            left++;
            }
        }
        return res;
    }
}
