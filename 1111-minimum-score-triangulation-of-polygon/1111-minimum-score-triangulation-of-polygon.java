class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for(int p=3; p<=n; p++){
            for(int i=0; i+p-1 < n; i++){
                int j = i+p-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i+1; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]+values[i]*values[j]*values[k]);
                }
            
            }

            // System.out.println(i+" "+Arrays.toString(dp[i]));
        }

        return dp[0][n-1];
    }
}