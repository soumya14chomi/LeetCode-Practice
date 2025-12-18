class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long totalSum =0, max =0, currSum =0, newSum =0;

        for(int i=0; i<prices.length ;i++){
            totalSum+=(prices[i] * strategy[i]);
        }

        for(int i=0; i<k; i++){
            currSum += (prices[i] * strategy[i]);
            if(i >= k/2){
                newSum+=(prices[i]);
            }
        }

        max = Math.max(totalSum, totalSum-currSum+newSum);
        for(int i=k; i<prices.length; i++){
            
            currSum= currSum - prices[i-k] * strategy[i-k] + prices[i] * strategy[i];

            int half =  i- k/2;

            newSum= newSum - prices[half] + prices[i];

            max = Math.max(max, totalSum-currSum+newSum); 

        // System.out.println(max+" "+currSum+" "+newSum);

        }

        return max;
    }
}