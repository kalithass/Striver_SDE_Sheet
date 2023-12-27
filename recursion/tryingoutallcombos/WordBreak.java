package strivers.recursion.tryingoutallcombos;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/word-break/
public class WordBreak  implements App {

    @Override
    public void run() {
        String s= "catsandog";
        List<String> list = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        boolean res = wordBreak(s, list);
        System.out.println(res);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        return recursiveHelper(s, wordSet, 0, dp);
    }

    private boolean recursiveHelper(String s, Set<String> wordSet, int start, int[] dp) {
        if (start == s.length()) return true;
        if(dp[start] == 1) return true;
        if(dp[start] == -1) return false;
        for (int i = start;i<s.length();i++) {
            String temp = s.substring(start, i+1);
            if(wordSet.contains(temp)) {
                if(recursiveHelper(s, wordSet, i+1, dp)) {
                    dp[start] = 1;
                    return true;
                }
            }
        }
        dp[start] = -1;
        return false;
    }
}
