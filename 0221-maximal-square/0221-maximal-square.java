class Solution {
    public int maximalSquare(char[][] matrix) {

        int max =0;
        int n= matrix.length, m = matrix[0].length;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0 && j>0)   {
                    if(matrix[i][j] == '1' && matrix[i-1][j-1] > '0' ){
                        int size = matrix[i-1][j-1] - '0';
                        boolean isValid = true;
                        for(int k = 0; k<=size; k++){
                            if(matrix[i][j-k] == '0'){
                                size = k-1;
                                break;
                            }
                        }

                        for(int k=0; k<=size; k++){
                            if(matrix[i-k][j] == '0'){
                                size =k-1;
                                break;
                            }
                        }
                        if(isValid)
                             matrix[i][j]=(char)(size+1+'0');
                    
                    }
                   
                }
                  max = Math.max(matrix[i][j] - '0', max);

            }
            System.out.println(Arrays.toString(matrix[i]));

        }
        return max*max;
 
    }
}