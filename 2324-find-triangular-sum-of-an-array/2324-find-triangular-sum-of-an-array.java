class Solution {
    public int triangularSum(int[] nums) {
        int res = 0;
        long[] temp = new long[nums.length];

        for(int i=0; i< nums.length; i++){
            long[] dp = new long[nums.length];
            for(int j=0; j<=i; j++){
                if(j==0 || j == i)    dp[j] = 1;
                else dp[j] = (temp[j-1]+temp[j])%10;

                // if(nums[j]!=0)  dp[j] = dp[j]%nums[j];
            }

            temp = dp;

            // System.out.println(Arrays.toString(temp));
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0)
                res = (int)(res+((temp[i])*nums[i])%10)%10;
        }

        return res;
    }
}