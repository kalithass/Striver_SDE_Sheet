package strivers.string.hard;

import strivers.App;

import java.util.Stack;

//https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770
public class MinCostToMakeStringValid implements App {

    @Override
    public void run() {
        String s = "{}}{}}";
        int res = findMinimumCost(s);
        System.out.println(res);
    }

    public static int findMinimumCost(String s) {
//        return usingStack(s);
        return withoutStack(s);
    }

    private static int withoutStack(String s) {
        if(s.length() % 2 == 1) return -1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                left++;
            } else {
                if (left > 0) left--;
                else right++;
            }
        }
        return (left + right) / 2 + (left % 2);
    }

    private static int usingStack(String s) {
        if(s.length() % 2 == 1) return -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                stack.push('{');
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else stack.push('}');
            }
        }
        int left = 0;
        int right = 0;
//        System.out.println(stack);
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '{') left++;
            else right++;
        }

        return (left + right) / 2 + (left % 2);
    }


    // Three possibilities observation
    //  }}{{{{ -> 2 4 -> 3
    //  }}}{{{ -> 3 3 -> 4 (if parentheses are odd, add 1 to the result)
    // }}}} -> 4 ->2
}
