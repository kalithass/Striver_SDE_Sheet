package strivers.binearysearch.onsums;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/aggressive-cows_1082559
public class AggressiveCows implements App {

    @Override
    public void run() {
        int[] arr = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int res = aggressiveCows(arr, k);
        System.out.println(res);
    }

    public static int aggressiveCows(int[] stalls, int k) {
        //    return naiveApproach(stalls, k);
        return optimalApproach(stalls, k);
    }

    private static int optimalApproach(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1;
        int n = stalls.length;
        int high = stalls[n-1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if(cowsCanBePlaced(stalls, mid, k)) low = mid+1;
            else high = mid-1;
        }
        return high;
    }

    private static int naiveApproach(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int high = stalls[n-1];
        for (int i = 1; i <= high; i++) {
            if (!cowsCanBePlaced(stalls, i, k)) return i - 1;
        }
        return high;
    }

    static boolean cowsCanBePlaced(int[] stalls, int minDistance, int k) {
        int lastPosition = 0, numberOfCowsPlaced = 1;
        for (int i = 1; i < stalls.length; i++) {
            // at least have min distance
            if (stalls[i] - stalls[lastPosition] >= minDistance) {
                lastPosition = i;
                numberOfCowsPlaced++;
            }
            if (numberOfCowsPlaced >= k) return true;
        }
        return false;
    }
}
