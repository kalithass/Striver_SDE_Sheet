package strivers.Trie.problems.maximumXorWithElementFromArray;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
public class MaximumXorWitHAnElementFromArray implements App {

    @Override
    public void run() {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = {{3, 1}, {1, 3}, {5, 6}};
//        int[] nums = {5,2,4,6,6,3};
//        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        int[] res = maximizeXor(nums, queries);
        System.out.println(Arrays.toString(res));
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int[][] offlineQueries = new int[queries.length][];


        for(int i=0;i<queries.length;i++) {
            int[] arr = queries[i];
            int[] temp = new int[3];
            temp[0] = arr[0];
            temp[1] = arr[1];
            temp[2] = i;
            offlineQueries[i] = temp;
        }

        Arrays.sort(offlineQueries, Comparator.comparingInt(e -> e[1]));

        int i = 0, j = 0;
        int[] res = new int[queries.length];

        Trie trie = new Trie();
        while (i < queries.length) {
            int  queryInd = offlineQueries[i][2];
            int num = offlineQueries[i][0];
            while (j < nums.length && nums[j] <= offlineQueries[i][1]) {
                trie.insert(nums[j]);
                j++;
            }
            if(j == 0) res[queryInd] = -1;
            else res[queryInd] = trie.getMax(num);
            i++;
        }
        return res;
    }
}
