class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] smaller = new int[n];

        smaller[0] = nums[0];
        int min = nums[0];
        for(int i=1; i<n; i++){
            if(min > nums[i])   min = nums[i];
            smaller[i] = min;
        }

        int large = nums[n-1];

        for(int i=n-2; i>=0; i--){

            if(large < nums[i]) large = nums[i];

            if(large!=nums[i] && smaller[i]!=nums[i])    return true;


        }

        return false;
        
    }
}