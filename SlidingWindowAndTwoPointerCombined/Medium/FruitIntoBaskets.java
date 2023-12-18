package strivers.SlidingWindowAndTwoPointerCombined.Medium;


import strivers.App;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.codingninjas.com/studio/problems/fruits-and-baskets_985356
public class FruitIntoBaskets implements App {

    @Override
    public void run() {
        int[] arr = {1, 1, 2, 3};
        int n = 4;
        int res = findMaxFruits(arr, n);
        System.out.println(res);
    }

    public static int findMaxFruits(int[] arr, int n) {
        int left = 0;
//        int right = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
