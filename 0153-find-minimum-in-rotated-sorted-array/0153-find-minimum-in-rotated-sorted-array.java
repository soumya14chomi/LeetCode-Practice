class Solution {
    public int findMin(int[] arr) {
        int l = 0, r = arr.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            System.out.println(arr[l]+" -> " + arr[mid]+ "-> "+arr[r]);

            if((mid == 0 || arr[mid] < arr[mid-1]) && (mid == arr.length-1 || arr[mid] < arr[mid+1]))  return arr[mid];
            if(arr[l] < arr[r]){
                if(arr[mid] > arr[l])   r = mid-1;
                else    l = mid+1;
            }
            else{
                if(arr[mid] < arr[l])   r = mid-1;
                else    l = mid+1;
            }
            
        }
        return -1;
    }
}