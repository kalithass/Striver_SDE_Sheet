package strivers.BitManipulation.advancedMaths;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codingninjas.com/studio/problems/prime-factorisation_1760849
public class CountPrimes implements App {

    @Override
    public void run() {
        int n = 10;
        List<Integer> res = countPrimes(n);
        System.out.println(res);
    }

    public static List< Integer > countPrimes(int n) {
        boolean[] marked = new boolean[n+1];
        for(int i=2;i*i<=n;i++) {
            if(!marked[i]) {
                for(int j = i*i; j<=n;j+=i) {
                    marked[j] = true;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<=n;i++) {
            if(!marked[i] && n%i == 0) res.add(i);
        }
        return res;
    }
}
