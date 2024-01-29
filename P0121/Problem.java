class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            var profit = prices[sell] - prices[buy];
            if (profit <= 0) {
                buy = sell;
            } else {
                maxProfit = Math.max(maxProfit, profit);
            }
            sell++;
        }

        return maxProfit;
    }
}