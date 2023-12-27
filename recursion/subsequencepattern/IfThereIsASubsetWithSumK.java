package strivers.recursion.subsequencepattern;

import strivers.App;

//https://www.codingninjas.com/studio/problems/subset-sum_630213
public class IfThereIsASubsetWithSumK implements App {

    @Override
    public void run() {
        int n = 3;
        int k = 5;
        int[] a = {1,2,3};
        boolean res = isSubsetPresent(n,k,a);
        System.out.println(res);
    }

    public static boolean isSubsetPresent(int n, int k,int []a) {
        return recursiveHelper(n,k,a);
    }

    private static boolean recursiveHelper(int n, int k, int[] a) {
        if (n == 0) return k == 0;
        if(k - a[n-1] >= 0) {
            if(recursiveHelper(n-1, k-a[n-1], a)) return true;
        }
        return recursiveHelper(n-1, k, a);
    }
}
