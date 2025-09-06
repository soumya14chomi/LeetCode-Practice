class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, min = Integer.MAX_VALUE, sum=0;

        for(; l<nums.length; l++){
            sum+=nums[l];
            while(sum>=target && r<nums.length){
                min = Math.min(min, l-r);
                sum-=nums[r++];
            }
            // System.out.println(l+" "+r+" "+sum+" "+min);

        }

        return min==Integer.MAX_VALUE? 0 :min+1;
    }
}