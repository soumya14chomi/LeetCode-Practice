class Solution {
    public int lengthOfLIS(int[] nums) {
        int curr = 1;
        for(int i=1;i<nums.length;i++){
            int idx = findLower(nums, curr, nums[i]);
            if(nums[idx] >= nums[i]) {
                nums[idx] = nums[i];
            }
            else{
                nums[curr++] = nums[i];
            }
        }

        return curr;
    }

    int findLower(int[] nums, int len, int target){
        int l = 0, r = len-1;
        while(l<r){
            int mid = (l+r)/2;

            if(target == nums[mid]) return mid;
            if(target < nums[mid])  r = mid;
            else    l =mid+1;
        }

        return l;
    }


}