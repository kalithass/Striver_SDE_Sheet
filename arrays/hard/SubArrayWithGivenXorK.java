package strivers.arrays.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.interviewbit.com/problems/subarray-with-given-xor/
public class SubArrayWithGivenXorK implements App {

    @Override
    public void run() {
        ArrayList<Integer> list = (ArrayList<Integer>) List.of(1,4,3,2,6);
        int goal = 11;
        int res = solve(list, goal);
        System.out.println(res);
    }

    /*
         0......j......i

         o to j = x
         j to i = k
         lets consider x ^ k = val
         we need x, so x ^ k ^ k = val ^ k
         x = val ^ k (similar to searching for sum-k)


     */
    public int solve(ArrayList<Integer> a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int val = 0;
        map.put(0,1);
        for (int ele : a) {
            val = val ^ ele;
            if (map.containsKey(val ^ target)) {
                count += map.get(val ^ target);
            }
            map.put(val, map.getOrDefault(val,0)+1);

        }
        return count;
    }
}
