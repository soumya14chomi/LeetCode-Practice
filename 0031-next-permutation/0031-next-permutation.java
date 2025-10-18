class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // if(nums[0] > nums[n-1]){
        //     // System.out.println("here");
        //     reverse(0, nums);
        //     return;
        // }  

        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                int idx = findSmallest(i, nums);
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;

                // System.out.println(Arrays.toString(nums));
                reverse(i+1, nums);
                return;
            }
        }

        reverse(0, nums);
    }
    void reverse(int idx, int[] nums){

        int l = idx, r = nums.length-1;

        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    int findSmallest(int i, int[] nums){
        int res = i+1;

        for(int idx = i+1; idx<nums.length;idx++){
            if(nums[i] < nums[idx] && nums[res] >= nums[idx])    res = idx;
        }

        // System.out.println(res);

        return res;
    }
}