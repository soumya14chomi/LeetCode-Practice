class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] dp = new long[n];
        
        dp[0] =  (long)(skill[0] * mana[0]);
        for(int i=1; i<n; i++)  dp[i] = dp[i-1] + (long)( skill[i] * mana[0]);

        // System.out.println(Array s.toString(dp));

        for(int i=1; i<mana.length;i++){
            long[] temp = new long[n];
            temp[0] = dp[0]+(long)(skill[0]*mana[i]);
            for(int j=1; j<n;j++){
                temp[j] = Math.max(dp[j], temp[j-1])+(long)(skill[j] * mana[i]);
            }

            dp[n-1] = temp[n-1];
 
            for(int j= n-2; j>=0; j--){
                dp[j] = dp[j+1]- (long)(skill[j+1] * mana[i]);

                // System.out.println(Arrays.toString(dp));
            }
        }

        return dp[n-1];
    }
}