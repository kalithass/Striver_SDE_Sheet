package strivers.stack.learning;
import strivers.App;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses implements App{

    @Override
    public void run() {
        String s = "()[]{}";
        boolean res = isValid(s);
        System.out.println(res);
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(st.isEmpty()) {
                st.push(ch);
                continue;
            }
            char top = st.peek();
            if(top == '{' && ch == '}') {
                st.pop();
            } else if (top == '(' && ch == ')') {
                st.pop();
            } else if (top == '[' && ch == ']') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
