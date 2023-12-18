package strivers.string.easy;

import strivers.App;

import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
public class MinimumAddToMakeParenthesisValid implements App {

    @Override
    public void run() {
        String s = "())";
        int res = minAddToMakeValid(s);
        System.out.println(res);
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') st.push('(');
            else {
                if(!st.isEmpty() && st.peek()=='(') st.pop();
                else st.push(')');
            }
        }
        return st.size();
    }
}
