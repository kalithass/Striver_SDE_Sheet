package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001
public class GenerateAllBinaryStrings implements App {

    @Override
    public void run() {
        int n = 4;
        List<String> res = generateString(n);
        System.out.println(res);
    }

    public static List< String > generateString(int N) {
        List<String> res = new ArrayList<>();
        recursionHelper(N, res, "");
        return res;
    }

    private static void recursionHelper(int n, List<String> res, String s) {
        if(n == 0) {
            res.add(s);
            return;
        }
        recursionHelper(n-1, res, s+"0");
        if(s.length() == 0 || s.charAt(s.length()-1) != '1')
            recursionHelper(n-1, res, s+"1");
    }
}

