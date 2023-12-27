package strivers.recursion.subsequencepattern;

import strivers.App;

import java.util.ArrayList;
import java.util.Collections;

//https://www.codingninjas.com/studio/problems/subset-sum_3843086
public class SubsetSum implements App {

    @Override
    public void run() {
        int[] num = {1,2};
        ArrayList<Integer> res = subsetSum(num);
        System.out.println(res);
    }

    public static ArrayList<Integer> subsetSum(int[] num) {
        ArrayList<Integer> res = new ArrayList<>();
        recursiveHelper(num, 0, res, 0);
        Collections.sort(res);
        return res;
    }

    private static void recursiveHelper(int[] a, int i, ArrayList<Integer> res, int sum) {
        if(i == a.length) {
            res.add(sum);
            return;
        }
        recursiveHelper(a, i+1, res, sum);
        recursiveHelper(a, i+1, res, sum+a[i]);
    }
}
