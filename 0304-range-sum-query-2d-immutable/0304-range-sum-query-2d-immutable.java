class NumMatrix {

    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int n= matrix.length, m=matrix[0].length;

        prefix = new int[n][m];

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                int sum = matrix[i][j];
                if(i>0) sum+=prefix[i-1][j];
                if(j>0) sum+=prefix[i][j-1];

                if(i>0 && j>0)  sum -= prefix[i-1][j-1];

                prefix[i][j] = sum;

            }

            System.out.println(Arrays.toString(prefix[i]));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.println(prefix[row2][col2] +" "+ prefix[row2][col1] +" "+ prefix[row1][col2] + " "+ prefix[row1][col1]);
        return prefix[row2][col2] - (col1>0 ? prefix[row2][col1-1] : 0) - (row1>0 ? prefix[row1-1][col2] : 0) + (row1 >0 && col1>0 ? prefix[row1-1][col1-1] : 0);
        }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */