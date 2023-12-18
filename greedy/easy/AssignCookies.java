package strivers.greedy.easy;

import strivers.App;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/assign-cookies/
public class AssignCookies implements App {

    @Override
    public void run() {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int res = findContentChildren(g, s);
        System.out.println(res);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int res = 0;
        while (i < g.length && j < s.length) {
            if(g[i] > s[j]) j++;
            else {
                i++;
                j++;
                res++;
            }
        }
        return res;
    }
}
