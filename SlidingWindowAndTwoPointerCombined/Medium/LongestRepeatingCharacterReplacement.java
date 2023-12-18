package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement implements App {

    @Override
    public void run() {
        String s = "ABAB";
        int k = 2;
        int res = characterReplacement(s, k);
        System.out.println(res);
    }

    public int characterReplacement(String s, int k) {
//        return betterApproach(s, k);
        return optimalApproach(s, k);
    }

    private int optimalApproach(String s, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int n = s.length();
        int[] arr = new int[26];
        int maxf = Integer.MIN_VALUE;
        while (right < n) {
            char ch = s.charAt(right);
            arr[ch - 'A']++;
            maxf = Math.max(maxf, arr[ch - 'A']);
            while (right - left + 1 - maxf > k) {
                arr[s.charAt(left) - 'A']--;
                maxf = getMax(arr);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    private int betterApproach(String s, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int n = s.length();
        int[] arr = new int[26];
        while (right < n) {
            char ch = s.charAt(right);
            arr[ch - 'A']++;
            int maxf = getMax(arr);
            while (right - left + 1 - maxf > k) {
                arr[s.charAt(left) - 'A']--;
                maxf = getMax(arr);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < 26; i++) max = Math.max(max, arr[i]);
        return max;
    }
}
