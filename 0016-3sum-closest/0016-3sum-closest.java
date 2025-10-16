class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);

        int res = target >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE, n= nums.length;

        if(nums[0] == nums[n-1]) {
            // if(target == nums[0]*3) return 0;
            return nums[0]*3;
        }

        for(int i=0; i<n; i++){

            int newVal  = target - nums[i];
            
            for(int j= i+1, k = n-1; j<k; ){

            // System.out.println(res+" "+ nums[i]);
                if(nums[j] + nums[k] == newVal){
                    return target;
                }

                if(Math.abs(res - target) > Math.abs(nums[j]+nums[k] - newVal)){
                    res = nums[j] + nums[k] + nums[i];
                }

                if(nums[j] + nums[k] > newVal)  k--;
                else    j++;
            }

        }

        return res;

    }
}