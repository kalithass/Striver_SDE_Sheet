package strivers.greedy.easy;

import strivers.App;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/valid-parenthesis-string/
public class ValidParenthesisChecker implements App {

    @Override
    public void run() {
        String s =  "(*)";
        boolean res = checkValidString(s);
        System.out.println(res);
    }


    /* took from leetcode comments
    Great solution. I reworded the explanation a bit for someone like myself who was still struggling after reading the solution
    There are two conditions in which the string is unbalanced
            1. We encounter too many ')'
            2. In the end, we still have some '(' which didn't find their matching ')'

    cmax takes care of condition 1
    cmax represents the number of ')' we MIGHT encounter. For cmax, we treat '*' as '('
    So at any point of time, if cmax becomes negative, that means, with all the '(' and '*' we have encountered, there are more ')'.
    So return false
    Note that we only worry about extra ')'

    cmin takes care of condition 2
    cmin represents the number of ')' we MUST encounter. So the job of cmin is to get to 0 as quickly as possible
    For cmin, we will always assume that '*' is a ')'. So whenever we encounter ')' or '*', we reduce cmin.
            But, cmin can not go below 0. If this happens, we can assume few of the '*'s as empty.
            Don't worry about a condition like ()))) because we have cmax which takes care of this.
    We only worry about extra '('
    So at the end, if cmin is still > 0, this means, with all the '*' and ')' we encountered, there are more '(' present in the string
    So return false

    */
    public boolean checkValidString(String s) {
        int left = 0; // cmax
        int leftWithStarAsClose = 0; // cmin
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                left++;
                leftWithStarAsClose++;
            }
            else if(ch == ')') {
                left--;
                leftWithStarAsClose--;
            } else {
                leftWithStarAsClose--;
                left++;
            }
            if(leftWithStarAsClose < 0) leftWithStarAsClose = 0;
            if(left < 0) return false;
        }
        return leftWithStarAsClose == 0;
    }
}
