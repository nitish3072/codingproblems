package leetcode.april.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * 1) maxProfit to be zero
 * 2) Use greedy algo to find the index with minimum price continuously otherwise we will fail if the minimum value is at last
 * 3) maxProfit is Math.max(prices[i] - prices[minIndex], maxProfit)
 */
public class BestTimeBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[minIndex] > prices[i]) {
                minIndex = i;
            }
            maxProfit = Math.max(prices[i] - prices[minIndex], maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeBuyAndSellStock bestTimeBuyAndSellStock = new BestTimeBuyAndSellStock();
        int[] prices = {2,4,1};
        System.out.println(bestTimeBuyAndSellStock.maxProfit(prices));
    }
}
