class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = 0, sum =0, n = nums.length;

        for(int i=0; i<n; i++){
            max+=(i*nums[i]);
            sum+=nums[i];
        }

        int curr = max;
        for(int i=1; i<n; i++){
            curr = curr + -(nums[n-i] * n) + sum;

            max = Math.max(curr, max);
        }

        return max;


    }
}