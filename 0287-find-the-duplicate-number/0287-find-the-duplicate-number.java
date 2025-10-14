class Solution {
    public int findDuplicate(int[] nums) {
        // int[] count = new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]< 0)   return idx+1;
            else    nums[idx] = -nums[idx];
        }

        return -1;
    }
}