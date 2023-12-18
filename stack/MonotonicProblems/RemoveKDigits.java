package strivers.stack.MonotonicProblems;


import strivers.App;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits implements App {

    @Override
    public void run() {
        String num = "1432219";
        int k = 3;
        String res = removeKdigits(num, k);
        System.out.println(res);
    }

    public String removeKdigits(String num, int k) {
        int n = num.length();

        if (n <= k) return "0";
        if (k == 0) return num;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                k--;
                stack.pop();
            }
            if (stack.isEmpty()) {
                if (ch != '0') stack.push(ch);
            } else {
                stack.push(ch);
            }
        }
        while (k != 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        if (stack.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
