package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class MinimumDaysToBuyBouquets implements App {

    @Override
    public void run() {
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int res = minDays(arr, m, k);
        System.out.println(res);
    }

    // day 7 => 1
    // day 10 => 2
    // day 12 => 3
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int low = 1;
        int high = getMax(bloomDay);
        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfBouquets = getNumberOfBouquetsThatCanBeMade(bloomDay, mid, k);
            if (numberOfBouquets >= m) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    int getNumberOfBouquetsThatCanBeMade(int[] bloomDay, int day, int k) {
        int totalBouquets = 0;
        int count = 0;
        for (int element : bloomDay) {
            if (element <= day) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                totalBouquets++;
                count = 0;
            }
        }
        return totalBouquets;
    }

    private int getMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int element : bloomDay) max = Math.max(max, element);
        return max;
    }
}
