class Solution {
    public int maxSubarraySumCircular(int[] num) {
        int totalSum = 0;
        int min =Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxSum =0, minSum=0;
        for(int i=0;i<num.length; i++){
            minSum+=num[i];
            maxSum+=num[i];

            totalSum+=num[i];

            min = Math.min(min, minSum);
            max = Math.max(max, maxSum);

            minSum = Math.min(minSum, 0);
            maxSum = Math.max(maxSum, 0);
        }

         if(totalSum == min) return max;

        return Math.max(max, totalSum-min);
    }
}