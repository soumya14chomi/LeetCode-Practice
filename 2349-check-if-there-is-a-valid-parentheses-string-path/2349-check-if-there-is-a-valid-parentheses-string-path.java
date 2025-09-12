class Solution {

    public boolean dp(char[][] grid, int[][][] dp, int i, int j, int n, int m, int open){
        if(i>=n || j>=m) return false;

        if(grid[i][j] == '(')   open++;
        else open--;

        if(open<0)  return false;

        if(dp[i][j][open]!=-1)   return dp[i][j][open] == 1;

        if(i==n-1 && j==m-1)    return open==0;

        boolean ans =  dp(grid, dp, i+1, j, n, m, open) || dp(grid, dp, i, j+1, n, m, open);
        dp[i][j][open] = ans ? 1:0;
        return ans;
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m+n];

        for(int[][] temp : dp){
            for(int[] row:temp){
                Arrays.fill(row, -1);
            }
        }

        // if(grid[0][0] == ')' || grid[n-1][m-1] == '(' || (n+m)%2 !=0)   return false;
        return dp(grid, dp, 0, 0, n, m, 0);

    }
}