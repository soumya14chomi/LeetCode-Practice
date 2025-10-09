class Solution {
    public boolean search(int[] nums, int t) {
        int l =0, r = nums.length-1;

        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] == t)   return true;


            if(l<r && nums[l] == nums[mid] && nums[mid] == nums[r]){
                l++;r--;
            }

            else if(nums[l] <=nums[mid]){
               if( nums[l] <= t && nums[mid] > t)  r = mid-1;
               else l = mid+1;
            }
            else{
                if(nums[mid] < t && nums[r] >=t) l = mid+1;
                else r = mid-1;
            }

            
        }

        return false;
    }
}