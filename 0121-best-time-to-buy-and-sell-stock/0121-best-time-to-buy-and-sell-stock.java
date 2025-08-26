class Solution {
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE, profit =0;

        for(int i=0;i <prices.length;i++){
            if(prices[i] < min_val) min_val = prices[i];
            if(prices[i] - min_val > profit)    profit = prices[i] - min_val;
        }

        return profit;

    }
}