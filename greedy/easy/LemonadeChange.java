package strivers.greedy.easy;

import strivers.App;

// https://leetcode.com/problems/lemonade-change/
public class LemonadeChange implements App {

    @Override
    public void run() {
        int[] bills = {5, 5, 5, 10, 20};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int element : bills) {
            if (element == 5) five++;
            else if (element == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                // (need on 10 and one 5) or (need 3 5)
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}
