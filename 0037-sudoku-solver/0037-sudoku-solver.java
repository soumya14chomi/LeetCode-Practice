class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++){
                if(board[i][j] == '.')   continue;
            //    if(rows[i][board[i][j]-'1'])  return false;
                rows[i][board[i][j]-'1'] = true;
            //    if(cols[j][board[i][j]-'1'])  return false;
                cols[j][board[i][j]-'1'] = true;
            }
        }

        helper(board, 0, 0, rows, cols);
    }

    boolean helper(char[][] board, int i, int j, boolean[][] rows, boolean[][] cols){
        if(i==9)    return true;

        int nextI = j == 8 ? i + 1 : i;
        int nextJ = j == 8 ? 0 : j + 1;

        if(board[i][j] !='.') {
            return helper(board, nextI, nextJ, rows, cols);
        }

        for(int num=0; num<9; num++){
            board[i][j] = (char)(num+'1');

            if(isValid(board, i, j, rows, cols)){
                rows[i][num] = true;
                cols[j][num] = true; 

                if(helper(board, nextI, nextJ, rows, cols)){
                    // System.out.println(i+" : " + Arrays.toString(board[i]));
                    return true;
                }
                rows[i][num] = false;
                cols[j][num] = false;
            }

            board[i][j] = '.';

            
        }

        return false;
    }

    boolean isValid(char[][] board, int i, int j, boolean[][] rows, boolean[][] cols){
        if(rows[i][board[i][j]-'1'])  return false;
         if(cols[j][board[i][j]-'1'])  return false;

         int idx1 = i/3;
         int idx2 = j/3;

        for(int row = 3*idx1; row< 3*(idx1+1); row++){
            for(int col = 3*idx2; col<3*(idx2+1); col++){
                if(row==i && col==j)    continue;
                if(board[i][j] == board[row][col])  {
                    // System.out.println("here:"+i+" "+j+":"+row+" "+col); 
                return false;
                }
                
            }
        }

        return true;


    }

        
}