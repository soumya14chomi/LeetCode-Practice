class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length, m = matrix[0].length;
        List<Integer> lst = new ArrayList<>();

        int t = 0, l = 0, b = n-1, r = m-1;

        while(t<=b && l<=r){
            for(int i=l; i<=r; i++){
                lst.add(matrix[t][i]);
            }
            t++;
            for(int i=t; i<=b; i++){
                lst.add(matrix[i][r]);
            }
            r--;
            if(t<=b){
                for(int i=r; i>=l; i--){
                lst.add(matrix[b][i]);
                }
            b--;
            }
            
            if(l<=r){
                for(int i=b; i>=t; i--){
                lst.add(matrix[i][l]);
            }
            l++;
            }
            

        }

        

        return lst;
    }
}