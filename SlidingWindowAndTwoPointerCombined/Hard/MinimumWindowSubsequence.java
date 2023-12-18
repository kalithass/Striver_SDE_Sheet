package strivers.SlidingWindowAndTwoPointerCombined.Hard;

import strivers.App;
//https://www.codingninjas.com/studio/problems/minimum-window-subsequence_2181133
public class MinimumWindowSubsequence implements App {

    @Override
    public void run() {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "abcdebdde";
        String t = "bde";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int start = 0;
        int end = n;
        int j = 0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == t.charAt(j)) {
                j++;
                if(j == t.length()) {
                    int currEnd = i;
                    j--;
                    while (j>=0) {
                        if(t.charAt(j) == s.charAt(i)) {
                            j--;
                        }
                        i--;
                    }
                    j++;
                    i++;
                    if(currEnd-i < end - start) {
                        start = i;
                        end = currEnd;
                    }
                }
            }
        }
        if(end == n) return "";
        return s.substring(start, end+1);
    }
}
