class Solution {
    public long getDescentPeriods(int[] prices) {
        // boolean onGoing = false;
        long res =1, prev = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] != prices[i-1]-1) {
                prev = i;
            }

            res += (i-prev+1);
            // System.out.println(prev+" "+ (i-prev) +" "+ res);
        }
            

        return res;
    }
}