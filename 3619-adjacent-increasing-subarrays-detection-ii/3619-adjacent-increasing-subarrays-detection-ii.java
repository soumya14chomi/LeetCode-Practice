class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int max = 1;

        int n= nums.size();
        int[] recdp = new int[n];
        int prev = nums.get(0);
        nums.set(0, 1);
        recdp[n-1] = 1;

        for(int i=n-2; i>=0; i--){
            if(nums.get(i)<nums.get(i+1))   recdp[i] = recdp[i+1]+1;
            else    recdp[i] = 1; 
        }

        for(int i=1; i<nums.size(); i++){
            int temp = nums.get(i);
            if(nums.get(i) > prev){
                nums.set(i, nums.get(i-1)+1);
            }

            else    nums.set(i, 1);

            prev = temp;

            if(i<n-1)   max = Math.max(max, Math.min(nums.get(i), recdp[i+1]));
        }

        // System.out.println(nums.toString() + " "  + Arrays.toString(recdp));

        return max;

    }
}