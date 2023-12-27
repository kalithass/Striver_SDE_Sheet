package strivers.recursion.tryingoutallcombos;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/expression-add-operators/
public class ExpressionAddOperators implements App {

    @Override
    public void run() {
        String num = "123";
        int target = 6;
        List<String> res = addOperators(num, target);
        System.out.println(res);
    }

    public List<String> addOperators(String num, int target) {
        List<String> ds = new ArrayList<>();
        helper(0, 0, target, new StringBuilder(), num, ds, 0);
        return ds;
    }

    public void helper(int ind, long prevCalculation, int target, StringBuilder res, String input, List<String> ds, long currVal) {
        if (ind == input.length()) {
            if (currVal == target) {
                ds.add(res.toString());
            }
            return;
        }

        for (int i = ind; i < input.length(); i++) {
            if (i > ind && input.charAt(ind) == '0') {
                return;
            }
            long val = Long.parseLong(input.substring(ind, i + 1));
            int len = res.length();
            if (ind == 0) {
                // 1023 -> start = 1 and i = 2,
                // if we continue without return we may get result as "1+02+3" for one of the target
                helper(i + 1, val, target, res.append(val), input, ds, val);
                res.setLength(len);

            } else {
                helper(i + 1, val, target, res.append("+").append(val), input, ds, currVal + val);
                /*
                    res = 1+2, and len = 3
                    if we add +23 it will become 1+2+23
                    after recursion to get back the original string we will use res.setLen(len)
                    here len = 3, so we will get back 1+2 and continue with (- and *)
                 */
                res.setLength(len);

                helper(i + 1, -val, target, res.append("-").append(val), input, ds, currVal - val);
                res.setLength(len);

                // 1+2+3*4 => 1+2+ 3 - 3 + (3*4) => 15
                //prevCalculation = 3, val = 4, currVal = 15, prevCalculation for next rec call = 12
                // at next recursion call
                // 1+2+3*4*5 => 1+2+ (3*4) - (3*4) + (3*4*5)
                helper(i + 1, val * prevCalculation, target, res.append("*").append(val), input, ds, currVal - prevCalculation + (prevCalculation * val));
                res.setLength(len);
            }
        }
    }
}
