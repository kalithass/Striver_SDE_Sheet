package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses  implements App {

    @Override
    public void run() {
        int n = 4;
        List<String> res = generateParenthesis(n);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursionHelper(res, "", n, n);
        return res;
    }

    private void recursionHelper(List<String> res, String s, int open, int close) {
        if(open == 0 && close == 0) {
            res.add(s);
            return;
        }
        if(open == close) recursionHelper(res, s+"(", open-1, close);
        else if (open == 0) recursionHelper(res, s+")", open, close-1);
        else {
            recursionHelper(res, s+"(", open-1, close);
            recursionHelper(res, s+")", open, close-1);
        }
    }
}
