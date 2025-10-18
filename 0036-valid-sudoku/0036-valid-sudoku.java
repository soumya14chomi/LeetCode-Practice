class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0; j<9;j++){
                if(board[i][j] == '.')   continue;
               if(rows[i][board[i][j]-'1'])  return false;
                rows[i][board[i][j]-'1'] = true;
               if(cols[j][board[i][j]-'1'])  return false;
                cols[j][board[i][j]-'1'] = true;
            }
        }

        System.out.println("here");

        for(int i=0; i<9; i++){
            for(int j=0; j<9 ;j++){

                if(board[i][j] == '.')   continue;

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

            }
        }

        return true;
    }
}