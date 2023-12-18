package strivers.Trie.problems.MaximumXor;

import strivers.App;

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class MaximumXor implements App {

    @Override
    public void run() {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int res = findMaximumXOR(nums);
        System.out.println(res);
    }

    public int findMaximumXOR(int []nums) {
        Trie trie = new Trie();
        for(int element : nums) trie.insert(element);
        int max = 0;
        for (int element : nums) max = Math.max(max, trie.getMax(element));
        return max;
    }
}
