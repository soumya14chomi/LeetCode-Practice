class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int n=arr.length, m= arr[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = arr[n-1][m-1] > 0 ? 0 : arr[n-1][m-1];

        for(int i=n-2; i>=0; i--){
            dp[i][m-1] = dp[i+1][m-1] + arr[i][m-1] > 0 ? 0 : dp[i+1][m-1] + arr[i][m-1];
        }

        for(int i=m-2; i>=0; i--){
            dp[n-1][i] = dp[n-1][i+1] + arr[n-1][i] > 0 ? 0 : dp[n-1][i+1] + arr[n-1][i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]) + arr[i][j] > 0 ? 0 : Math.max(dp[i+1][j], dp[i][j+1]) + arr[i][j];
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        return Math.abs(dp[0][0]) + 1;
    }
}