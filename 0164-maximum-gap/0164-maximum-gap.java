class Solution {
    public int maximumGap(int[] nums) {

        if(nums.length<2)   return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;



        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if(max-min ==0) return 0;

        int n = nums.length, gap = (int) Math.ceil((max - min) * 1.0 / (n - 1));
;

        System.out.println(gap);

        int[] minBucket = new int[n+1];
        int[] maxBucket = new int[n+1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);

        for(int val : nums){
            // if(val == min || val == max)    continue;
            int idx = (val-min)/gap;

            minBucket[idx] = Math.min(val, minBucket[idx]);
            maxBucket[idx] = Math.max(val, maxBucket[idx]);

        }

        for(int i=0; i<n+1; i++){
            System.out.println(minBucket[i]+" "+maxBucket[i]);
        }
        int prev = 0;
        for(int i=1; i<n; i++){
            if(minBucket[i] == Integer.MAX_VALUE) continue;
            gap = Math.max(minBucket[i] - maxBucket[prev], gap);
            prev = i;
        }

        return gap;

    }
}