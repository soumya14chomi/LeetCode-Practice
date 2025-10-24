class Solution {
    public int minPatches(int[] nums, int n) {
        // int missing = 1;
        int res = 0;

        Arrays.sort(nums);

        int idx =0;

        for(long i=1; i<=n;){

            // System.out.println(i);

            if(idx< nums.length && nums[idx]<=i) {
                i += nums[idx];
                idx++;
            }
            else{
                res++;
                i+=i;
            }

            

        }

        return res;
    }

    
}