package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaximumPointsYouCanObtainFromCards implements App {

    @Override
    public void run() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int res = maxScore(cardPoints, k);
        System.out.println(res);
    }

    public int maxScore(int[] cardPoints, int k) {
        // find minimum sum of sub array with n-k
        // int sum = 0;
        // for (int element : cardPoints) {
        //     sum += element;
        // }
        // return sum - subArrayWithMinimumSum(cardPoints, cardPoints.length - k);

        int totalSum = 0;
        int sum = 0;
        int res = 0;

        k = cardPoints.length - k;

        for (int i = 0; i < cardPoints.length; i++) {
            totalSum += cardPoints[i];
            sum += cardPoints[i];
            if(i < k) {
                res += cardPoints[i];
            } else {
                sum = sum - cardPoints[i-k];
                res = Math.min(sum, res);
            }
        }
        return totalSum - res;
    }

    private int subArrayWithMinimumSum(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int res = sum;

        for(int i=k; i<cardPoints.length;i++) {
            sum = sum + cardPoints[i] - cardPoints[i-k];
            res = Math.min(sum, res);
        }
        return res;
    }
}

// op - 207 exp - 232
// 11,49,100,20,86,29,72
// 11,49,100,20,86,29
// 11,49,100,20,86
// 11,49,100,20
// 11,49,100

// 72 + 29 + 100 + 20 =>