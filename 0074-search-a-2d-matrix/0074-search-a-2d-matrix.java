class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l =0, r = matrix.length-1;
        int m = matrix[0].length-1;

        if(target < matrix[0][0] || target > matrix[matrix.length-1][m]) return false;

        while(l<r){
            int mid = (l+r)/2;
            if(matrix[mid][m] < target) l  =mid+1;
            else    r = mid;
        }

        int i = r;
         l=0;
          r = matrix[l].length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[i][mid] ==target) return true;
            if(matrix[i][mid] < target)    l = mid + 1;
            else r = mid-1;
        }

        return false;
    }
}