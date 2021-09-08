class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int low = prices[0];
        int profit = 0;
        for(int price : prices){
            low = Math.min(price, low);
            profit = Math.max(profit, price - low);
        }
        return profit;
    }
}
