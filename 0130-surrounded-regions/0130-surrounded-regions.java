class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && visited[i][0] == 0){
                dfs(board, i, 0, n, m, visited);
            }  
        }

        for(int i=0; i<m;i++){
            if(board[0][i] == 'O' && visited[0][i] == 0){
                dfs(board, 0, i, n, m, visited);
            }  
        }

        for(int i=0; i<m;i++){
            if(board[n-1][i] == 'O' && visited[n-1][i] == 0){
                dfs(board, n-1, i, n, m, visited);
            }  
        }

        for(int i=0;i<n;i++){
            if(board[i][m-1] == 'O' && visited[i][m-1] == 0) {
                dfs(board, i, m-1, n, m, visited);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O' && visited[i][j] ==0) board[i][j] = 'X';
            }
        }
    }

    void dfs(char[][] board, int i, int j, int n, int m, int[][] visited){
        if(visited[i][j] == 1 || board[i][j] == 'X')  return;
        visited[i][j] = 1;
        if(i>0) dfs(board, i-1, j, n, m, visited);
        if(j>0) dfs(board, i, j-1, n, m, visited);
        if(i<n-1) dfs(board, i+1, j, n, m, visited);
        if(j<m-1)   dfs(board, i, j+1, n, m, visited);

    }
}