package strivers.recursion.tryingoutallcombos;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning
public class PalindromePartitioning implements App {

    @Override
    public void run() {
        String s= "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recursiveHelper(s, new ArrayList<>(), 0, res);
        return res;
    }

    private void recursiveHelper(String s, ArrayList<String> list, int start, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i=start;i<s.length();i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i+1));
                recursiveHelper(s, list, i+1, res);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
