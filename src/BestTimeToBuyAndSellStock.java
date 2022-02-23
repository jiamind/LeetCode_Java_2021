/**
 * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int buyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
