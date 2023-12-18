package strivers.greedy.mediumAndHard;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/candy/
public class Candy implements App {

    @Override
    public void run() {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        int res = candy(ratings);
        System.out.println(res);
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) candies[i] = candies[i+1]+1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) res += candies[i];

        System.out.println(Arrays.toString(candies));

        return res;
    }
}
