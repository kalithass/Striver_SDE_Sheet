package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas implements App {

    @Override
    public void run() {
        int[] arr = {3, 6, 7, 11};
        int res = minEatingSpeed(arr, 8);
        System.out.println(res);
    }

    // k = 1 => 3 + 6 + 9 + 11 => 29
    // k = 2 => 2 + 3 + 5 + 6 => 16
    // k =3 => 11
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        while (low <= high) {
            int mid = (low+high) /2;
            int completionTime = getCompletionTime(piles, mid);
            if (completionTime > h) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    int getCompletionTime(int[] piles, int mid) {
        int t = 0;
        for(int i: piles) {
            t += Math.ceil((double)(i) / (double)(mid));
        }
        return t;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int element : piles) max = Math.max(max, element);
        return max;
    }
}
