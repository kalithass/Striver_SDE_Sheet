package strivers.stack.PreInPostFixProblems;

import strivers.App;

import java.util.Stack;

//https://www.codingninjas.com/studio/problems/day-23-:-infix-to-postfix-_1382146
public class InfixToPostfix implements App {

    @Override
    public void run() {
//        String s = "3+4*8";
        String s = "3^(1+1)";
        String res = infixToPostfix(s);
        System.out.println(res);
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (notAnOperator(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty()) {
                    char top = st.pop();
                    if (top == '(') {
                        break;
                    } else {
                        sb.append(top);
                    }
                }
            } else {
                if (st.isEmpty()) st.add(ch);
                else {
                    while (!st.isEmpty()) {
                        char top = st.peek();
                        if (isTopHigherOrSamePrecedence(top, ch)) {
                            sb.append(st.pop());
                        } else break;
                    }
                    st.add(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    private static boolean notAnOperator(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static boolean isTopHigherOrSamePrecedence(char top, char ch) {
//        if(ch == top) return true;
//        if (top == '^') {
//            return ch == '*' || ch == '/' || ch == '+' || ch == '-';
//        } else if (top == '/') {
//            return ch == '*' || ch == '+' || ch == '-';
//        } else if (top == '*') {
//            return ch == '+' || ch == '-' || ch == '/';
//        } else if (top == '+') {
//            return ch == '-';
//        } else if (top == '-') {
//            return ch == '+';
//        }
//        return false;

        /*
            char[] p1 = {'(', ')'};
            char[] p2 = {'^'};
            char[] p3 = {'/', '*'};
            char[] p4 = {'+', '-'};
        */

        int topPriority = getPriority(top);
        int chPriority = getPriority(ch);
        return topPriority >= chPriority;
    }

    static int getPriority(char ch) {
        if(ch == '^') return 3;
        if(ch == '/' || ch == '*') return 2;
        if(ch == '+' || ch=='-') return 1;
        return -1;
    }
}
