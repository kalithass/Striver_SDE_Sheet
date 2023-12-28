package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombination implements App {

    @Override
    public void run() {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }

    public List<String> letterCombinations(String digts) {
        return recursivepproach(digts);
//        return iterativeApproach(digts);
    }

    private List<String> recursivepproach(String digts) {
        List<String> res = new ArrayList<>();
        if (digts.length() > 0) recursiveHelper(digts, 0, res, getMap(), "");
        return res;
    }

    private void recursiveHelper(String digits, int ind, List<String> res, Map<Character, String> map, String s) {
        if (ind == digits.length()) res.add(s);
        else {
            for (char ch : map.get(digits.charAt(ind)).toCharArray()) {
                recursiveHelper(digits, ind+1, res, map, s+ch);
            }
        }

    }

    private static LinkedList<String> iterativeApproach(String digts) {
        Map<Character, String> map = getMap();
        LinkedList<String> queue = new LinkedList<>();
        if (digts.length() == 0) return queue;
        queue.add("");
        for (int i = 0; i < digts.length(); i++) {
            String temp = map.get(digts.charAt(i));
            while (queue.peek().length() == i) {
                for (char ch : temp.toCharArray()) {
                    queue.add(queue.poll() + ch);
                }
            }
        }
        return queue;
    }

    private static Map<Character, String> getMap() {
        return Map.of(
                '0', "0",
                '1', "1",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
    }
}
