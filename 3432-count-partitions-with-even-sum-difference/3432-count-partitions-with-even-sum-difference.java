class Solution {
    public int countPartitions(int[] nums) {
        int sumLeft = 0, sumRight =0;
        for(int i=0; i<nums.length; i++)    sumLeft+=nums[i];

        int res =0;
        for(int i=0; i<nums.length-1; i++)    {
            sumLeft-= nums[i];
            sumRight-=nums[i];
            if(Math.abs(sumLeft-sumRight)%2 ==0)   res++;
        }

        return res;
    }
}