class Solution {
    public int maximumEnergy(int[] dp, int k) {
        int max = Integer.MIN_VALUE;
        int n = dp.length;

        for(int i=0; i<k;i++){
            if(i+k >=n) max = Math.max(dp[i], max);
        }

        for(int i=k;i<n;i++){
            if(dp[i-k] > 0) dp[i] =dp[i] + dp[i-k];

            if(i+k >=n) max = Math.max(dp[i], max);
        }

        return max;
    }
}