class Solution {
    int bsFloor(int[] arr, int target){
        int l = 0, r = arr.length-1, res = r;

        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid] >= target){
                res = mid;
                l = mid+1;
            }

            else{
                r = mid-1;
            }
        }

        return res;
    }

    int bsCeil(int[] arr, int target){
        int l = 0, r = arr.length-1, res = l;

        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid] <= target){
                res = mid;
                r = mid-1;

            }
            else{
                l = mid+1;
            }

        }

        return res;
    }

    boolean bs(int[] arr, int target){
        int l=0,  r =arr.length-1;


        while(l<=r){
            int mid = (l+r)/2;

            System.out.println(l+" "+r+ " "+mid);

            if(arr[mid] == target) return true;
            if(arr[mid] > target)   r = mid-1;
            else    l= mid+1;
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m=matrix[0].length;
        int[] first = new int[n];
        int[] last = new int[n];

        for(int i=0;i<n;i++){
            first[i] = matrix[i][0];
            last[i] = matrix[i][m-1];
        }

        int idx1 = bsCeil(last, target);
        int idx2 = bsFloor(first, target);

        // System.out.println(idx1+ " "+ idx2);

        // System.out.println("first:"+Arrays.toString(first));
        // System.out.println("last:"+Arrays.toString(last));

        for(int i = idx1; i<=idx2; i++){

            if(bs(matrix[i], target))   return true;
        }

        return false;
    }
}