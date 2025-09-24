class Solution {
    public int[] searchRange(int[] arr, int target) {
        int l = 0 ,r = arr.length-1;
        int floor = -1, ceil =-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid] == target){
                floor = mid;
                r = mid-1;
            }

            else if(arr[mid] > target){
                r = mid-1;
            }
            else    l = mid+1;
        }

        if(floor == -1) return new int[]{-1, -1};

        l = 0; r = arr.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                ceil = mid;
                l = mid+1;
            }
            else if(arr[mid] < target)  l=mid+1;
            else    r = mid-1;
        }

        return new int[]{floor, ceil};
    }
}