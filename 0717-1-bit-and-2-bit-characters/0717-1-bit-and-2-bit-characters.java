class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        boolean[] dp = new boolean[n];

        dp[0] = true;
        for(int i=0; i<n-1; i++){
            dp[i+1] = false;
            if(i>=1 && bits[i-1] == 1) dp[i+1] |= dp[i-1];
            if(bits[i] == 0)  dp[i+1] = true; 
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}