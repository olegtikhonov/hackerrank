package test.twest.leetcode;


/**
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class EasyBestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 1;
        int profit = 0;

        while (sell < prices.length) {
            if (profit < (prices[sell] - prices[buy])) {
                profit = prices[sell] - prices[buy];
            }

            if ((prices[sell] - prices[buy]) <= 0) {
                buy = sell;
            }

            ++sell;
        }

        return profit;
    }

    public static void main(String[] args) {
        EasyBestTimeToBuySellStock stockExchange = new EasyBestTimeToBuySellStock();
        int[] pricesWithProfit = new int[] {7,1,5,3,6,4};
        int profit = stockExchange.maxProfit(pricesWithProfit);
        System.out.println("Profit:=" + profit);

        int[] noProfit = new int[] {7,6,4,3,1};
        profit = stockExchange.maxProfit(noProfit);
        System.out.println("Profit:=" + profit);
    }
}
