class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int n=arr.length, m= arr[0].length;
        // int[][] dp = new int[n][m];
        arr[n-1][m-1] = arr[n-1][m-1] > 0 ? 0 : arr[n-1][m-1];

        for(int i=n-2; i>=0; i--){
            arr[i][m-1] = arr[i+1][m-1] + arr[i][m-1] > 0 ? 0 : arr[i+1][m-1] + arr[i][m-1];
        }

        for(int i=m-2; i>=0; i--){
            arr[n-1][i] = arr[n-1][i+1] + arr[n-1][i] > 0 ? 0 : arr[n-1][i+1] + arr[n-1][i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]) + arr[i][j] > 0 ? 0 : Math.max(arr[i+1][j], arr[i][j+1]) + arr[i][j];
            }
            // System.out.println(Arrays.toString(dp[i]));
        }

        return Math.abs(arr[0][0]) + 1;
    }
}