class Solution {
    public int findMin(int[] arr) {
         int  l=0, r = arr.length-1, res = arr[0];
         while(l<r){
            int mid = (l+r)/2;
            // System.out.println(l+" "+r+" "+mid);
            if(arr[mid] == arr[l] && arr[mid] == arr[r]){
                l++;
                r--;
            }
            else if(arr[mid] > arr[r]){
                //    res = Math.min(res, arr[mid]);
                   l = mid+1;
                   }
            else{
                // res = Math.min(res, arr[l]);
                r = mid;
            }
         }

         return arr[l];
    }
}