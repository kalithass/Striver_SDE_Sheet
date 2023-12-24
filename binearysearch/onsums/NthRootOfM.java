package strivers.binearysearch.onsums;

import strivers.App;

//https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679
public class NthRootOfM implements App {

    @Override
    public void run() {
        int res = NthRoot(3, 27);
        System.out.println(res);
    }

    public static int NthRoot(int n, int m) {
        int low = 0, high = m;
        while (low <=high) {
            int mid = (low+high)/2;
            int compareValue = nPowmid(mid, n, m);
            if (compareValue == 0) return mid;
            if(compareValue == 1) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private static int nPowmid(int mid, int n, int m) {
        long res = 1;
        for(int i=1;i<=n;i++) {
            res = res*mid;
            if(res >m) return 1;
        }
        return res == m ? 0 : -1;
    }
}
