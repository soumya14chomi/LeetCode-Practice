class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        int[] dp = new int[m];

        for(int i=0;i<n;i++){
            int[] temp = new int[m];
            for(int j=0;j<m;j++){
                if(i == 0 && j==0)  temp[j] = grid[i][j];
                else if(i==0)   temp[j] = temp[j-1]+grid[i][j];
                else if(j==0)   temp[j] = dp[j] + grid[i][j];
                else    temp[j] = Math.min(temp[j-1]+grid[i][j], dp[j] + grid[i][j]);
             }

             dp = temp;
        }

        return dp[m-1];
    }
}