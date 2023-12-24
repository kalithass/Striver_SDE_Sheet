package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackages implements App {

    @Override
    public void run() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int res = shipWithinDays(weights, days);
        System.out.println(res);
    }

    // 2 -> 8
    // 14 -> 6
    // 15 -> 5
    // 16 -> 5
    // 20 -> 4
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);
        while (low <= high) {
            int mid = (low+high)/2;
            int currentDays = getDaysToShipWithTheGivenCapacity(weights, mid);
            if (currentDays > days) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private int getSum(int[] weights) {
        int res = 0;
        for (int element : weights) res += element;
        return res;
    }

    int getDaysToShipWithTheGivenCapacity(int[] weights, int capacity) {
        int days = 1;

        int currentWeight = 0;
        for(int element : weights) {
            if(currentWeight + element > capacity) {
                days++;
                currentWeight = element;
            }  else {
                currentWeight += element;
            }
        }

        return days;
    }

    private int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int element : weights) max = Math.max(max, element);
        return max;
    }
}
