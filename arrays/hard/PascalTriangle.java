package strivers.arrays.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle  implements App {

    @Override
    public void run() {
        List<List<Integer>> res = generate(5);
        System.out.println(res);
    }

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            res.add(getNthRow(i));
        }
        return res;
    }

    private List<Integer> getNthRow(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        int ans = 1;
        for(int i=1;i<n;i++) {
            ans = ans * (n-i);
            ans = ans/i;
            res.add(ans);
        }
        return res;
    }

}
