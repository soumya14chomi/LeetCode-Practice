class Solution {
    public int coinChange(int[] coins, int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1;i<=n;i++){
            for(int j=0;j<coins.length; j++){
                if(i - coins[j] >=0 && dp[i-coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE? -1 : dp[n];
    }
}