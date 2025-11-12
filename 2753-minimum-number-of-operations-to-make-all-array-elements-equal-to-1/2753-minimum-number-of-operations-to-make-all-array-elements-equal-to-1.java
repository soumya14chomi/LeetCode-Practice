class Solution {
    public int minOperations(int[] nums) {
        int ones =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1)    ones++;
        }
        if(ones>0)  return nums.length-ones;

        int  gcd = nums[0];

        for(int i=1; i<nums.length;i++){
             gcd = gcd(gcd, nums[i]);
        }
        if(gcd!=1)  return -1;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++){
            gcd = nums[i];
            for(int j=i+1; j<nums.length; j++){
                gcd = gcd(gcd, nums[j]);
                if(gcd == 1)    min = Math.min(min,  (j-i+nums.length-1));
            }
        }

        return min;
    }

    int gcd(int a, int b){
        if(b==0)    return a;
        return gcd(b, a%b);
    }
}