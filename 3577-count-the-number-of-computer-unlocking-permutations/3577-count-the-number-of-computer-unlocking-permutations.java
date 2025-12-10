class Solution {
    public int countPermutations(int[] nums) {
        for(int i=1;i<nums.length; i++){
            if(nums[i] <= nums[0])  return 0;
        }
        int res = 1;
        final int MOD= 1000000007;
        for(int i=1; i<nums.length; i++){
            res = (int)(((long)res*i)%MOD);
        }

        return res;
    }
}