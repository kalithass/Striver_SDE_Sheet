package strivers.binearysearch.onsums;

import strivers.App;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.codingninjas.com/studio/problems/minimise-max-distance_7541449
public class MinimizeMaxGasStation implements App {

    @Override
    public void run() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 6;
        double res = MinimiseMaxDistance(arr, k);
        System.out.println(res);
    }

    public static double MinimiseMaxDistance(int[] arr, int K) {
//        return naiveApproach(arr, K);
//        return betterApproach(arr, K);
        return optimalApproach(arr, K);
    }

    private static double optimalApproach(int[] arr, int k) {

        double low = 0;
        double high = 0;
        int n = arr.length;
        for (int i=0;i<n-1;i++) {
            high = Math.max(high, (arr[i+1] - arr[i]));
        }

        double maxDiff = 1e-6;
        while (high - low > maxDiff) {
            double mid = (low+high)/2.0;
            if(numberOfGasStationsCanBePlaced(arr, mid) > k) low = mid;
            else high = mid;
        }
        return high;
    }

    private static int numberOfGasStationsCanBePlaced(int[] arr, double distance) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int currentPlaced = (int)((arr[i+1] - arr[i]) / distance);
            if (currentPlaced * distance == (arr[i+1] - arr[i])) currentPlaced--;
            count += currentPlaced;
        }
        return count;
    }

    // gasStation             [1 13 16] -> x
    // numberOfStationsPlaced   [0, 0] -> y
    // (x[1]-x[0]) / y[1]=> equal distance between the 0 and 1st gas station
    private static double naiveApproach(int[] arr, int k) {
        int n = arr.length;
        double[] numberOfStationsPlaced = new double[n - 1];
        for (int i = 0; i < k; i++) {
            int indexWhichHasTheMaximumDistance = -1;
            double maxGasDistance = -1;
            for (int j = 0; j < n - 1; j++) {
                double currentGasDistance = (arr[j + 1] - arr[j]) / (numberOfStationsPlaced[j] + 1);
                if (currentGasDistance > maxGasDistance) {
                    indexWhichHasTheMaximumDistance = j;
                    maxGasDistance = currentGasDistance;
                }
            }
            numberOfStationsPlaced[indexWhichHasTheMaximumDistance]++;
        }
        return getMaxDistance(arr, n, numberOfStationsPlaced);
    }

    // use priority queue instead of finding max each time by running n times
    private static double betterApproach(int[] arr, int k) {
        int n = arr.length;
        double[] numberOfStationsPlaced = new double[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(e -> -e.gasDistance));
        for (int i = 0; i < n - 1; i++) {
            double gasDistance = (arr[i + 1] - arr[i]);
            pq.add(new Pair(gasDistance, i));
        }
        for (int i = 0; i < k; i++) {
            int maxIndex = pq.poll().index;
            numberOfStationsPlaced[maxIndex]++;
            double gasDistance = (arr[maxIndex + 1] - arr[maxIndex]) / (numberOfStationsPlaced[maxIndex] + 1);
            pq.add(new Pair(gasDistance, maxIndex));
        }
        return pq.peek().gasDistance;
    }

    private static double getMaxDistance(int[] arr, int n, double[] numberOfStationsPlaced) {
        double max = -1;
        for (int i = 0; i < n - 1; i++) {
            double gasDistance = (arr[i + 1] - arr[i]) / (numberOfStationsPlaced[i] + 1);
            max = Math.max(max, gasDistance);
        }
        return max;
    }

    static class Pair {
        double gasDistance;
        int index;

        public Pair(double gasDistance, int index) {
            this.gasDistance = gasDistance;
            this.index = index;
        }
    }
}
