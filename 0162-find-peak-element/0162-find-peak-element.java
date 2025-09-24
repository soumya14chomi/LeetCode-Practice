class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;

        if(n==1)    return 0;
        if(arr[n-1] > arr[n-2])   return n-1;
        if( arr[0] > arr[1]) return 0;

        int l = 0, r = n-1;

        while(l<=r){
            int mid= (l+r)/2;

            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == n-1 || arr[mid] > arr[mid+1]))    return mid;
            if(arr[mid] < arr[mid+1])   l = mid+1;
            else    r = mid-1;
        }

        return -1;
    }
}