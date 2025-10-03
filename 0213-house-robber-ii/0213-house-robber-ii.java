class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        int n= nums.length;
        int[] nums1 = new int[n];

        nums1[0] = 0;

        nums1[1] = nums[1];
        if(nums[1] <nums[0])    nums[1] = nums[0];

        for(int i=2; i<n;i++){
            nums1[i] = Math.max(nums1[i-1], nums1[i-2]+nums[i]);
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
            
           
        }

        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(nums1));

        return Math.max(nums[n-2], nums1[n-1]);


        
    }
}