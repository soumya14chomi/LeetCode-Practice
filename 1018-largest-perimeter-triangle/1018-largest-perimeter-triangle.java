class Solution {
    public int largestPerimeter(int[] nums) {
        if(nums.length < 3) return 0;

        Arrays.sort(nums);

        int n = nums.length;

        int l1 = n-1 , l2 = n-2, l3 = n-3;

        for(; l3>=0; l1--, l2--, l3--){
            if(nums[l1] < nums[l2]+nums[l3])  return nums[l1]+nums[l2]+nums[l3];  
        }

        return 0;
    }
}