class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length, m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                // System.out.println(board[i][j] + " "+word.charAt(i));
                if(helper(board, word, i, j, 0)){
                     return true;
                }   
                //  System.out.println();
            }
        }

        return false;
    }

    boolean helper(char[][] board, String word, int i, int j, int idx){
        
        if(idx == word.length()) {

           
             return true;
        }

        if(i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] == '*')    return false;

        if(board[i][j] == word.charAt(idx)){
            //  System.out.print(word.charAt(idx)+"("+idx+") ->");

            char ch = board[i][j];
            board[i][j] = '*';
            boolean res = helper(board, word, i-1, j, idx+1)  
                    || helper(board, word, i, j-1, idx+1)
                    || helper(board, word, i+1, j, idx+1)
                    || helper(board, word, i, j+1, idx+1);
            board[i][j] = ch;
            return res;
        }
        return false;
    }
}