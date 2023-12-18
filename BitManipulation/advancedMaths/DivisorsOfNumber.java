package strivers.BitManipulation.advancedMaths;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/studio/problems/print-all-divisors-of-a-number_1164188
public class DivisorsOfNumber implements App {

    @Override
    public void run() {
        int n = 5;
        List<Integer> res = printDivisors(n);
        System.out.println(res);
    }

    public static List< Integer > printDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(n%i == 0) list.add(i);
        }
        return list;
    }
}
