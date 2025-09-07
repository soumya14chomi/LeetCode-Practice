class Solution {

    int count(int[][] board, int m, int n, int i, int j){
        int res =0;
        if(i>0) res+=board[i-1][j]%2;
        if(j>0) res+=board[i][j-1]%2;
        if(i>0 && j>0)  res+=board[i-1][j-1]%2;
        if(i>0 && j<m-1)    res+=board[i-1][j+1]%2;
        if(j>0 && i<n-1)    res+=board[i+1][j-1]%2;
        if(j<m-1)   res+=board[i][j+1]%2;
        if(i<n-1)   res+=board[i+1][j]%2;
        if(i<n-1 && j<m-1)  res+=board[i+1][j+1]%2;

        return res;
    }

    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count = count(board, m, n, i, j);

                if(board[i][j] == 1){
                    if(count ==2 || count == 3) board[i][j]+=2;
                }

                else{
                    if(count == 3)  board[i][j]+=2;
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = board[i][j]/2;
            }
        }

    }
}