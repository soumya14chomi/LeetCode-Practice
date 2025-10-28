class Solution {
    public int countValidSelections(int[] nums) {



        for(int i=1; i<nums.length; i++){
            nums[i]+=nums[i-1];

        }

        int total = nums[nums.length-1];

        if(total == 0)    return nums.length*2;

        int res =0;

        for(int i=0; i<nums.length; i++){
            if( (i==0 && nums[i] == 0) || (i>0 && nums[i] == nums[i-1])) {
                if(nums[i] == total - nums[i]) res+=2;
                else if(Math.abs(total - 2*nums[i]) == 1)    res+=1;

            }
            
            
        }
        // System.out.println(Arrays.toString(nums)+" "+total);
        return res;

        
    }
}