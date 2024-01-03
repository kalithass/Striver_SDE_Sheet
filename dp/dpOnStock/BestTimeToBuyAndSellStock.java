package strivers.dp.dpOnStock;

import strivers.App;
import strivers.Main;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock implements App {


    @Override
    public void run() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int profit = 0;
        for (int i=1;i<prices.length;i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            profit = Math.max(prices[i]-minSoFar, profit);
        }
        return profit;
    }
}
