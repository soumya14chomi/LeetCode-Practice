class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;

        // int row = 0;

        for(int idx =0; idx<n/2; idx++){
            int[] temp = new int[n];
            for(int i=0;i<n;i++)    temp[i] = matrix[idx][i];
            for(int i=idx+1; i<n-idx;i++){

                // System.out.println("("+(idx)+", "+i+") -> ("+(n-1-i)+", "+(idx)+" )");
                matrix[idx][i] = matrix[n-1-i][idx];
            }

            for(int i=idx; i<n-1-idx;i++){
                // System.out.println("("+(i)+", "+idx+") -> ("+(n-1-idx)+", "+(i)+" )");
                matrix[i][idx] = matrix[n-1-idx][i];
            }

            for(int i=idx; i<n-idx-1;i++){
                // System.out.println("("+(n-1-idx)+", "+i+") -> ("+(n-1-i)+", "+(n-1-idx)+" )");
                matrix[n-1-idx][i] = matrix[n-1-i][n-1-idx];
            }

            for(int i = idx+1; i<n-idx;i++){
                // System.out.println("("+(i)+", "+(n-1-idx)+") -> ("+(idx)+", "+(i)+" )");
                matrix[i][n-1-idx] = temp[i];
            }
        }

    }
}