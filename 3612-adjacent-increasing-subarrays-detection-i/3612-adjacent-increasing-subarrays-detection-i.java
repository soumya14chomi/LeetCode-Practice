class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            // int[] count = new int[nums.size()];

            int prev = -10001;

            for(int i=0; i<nums.size(); i++){

                int temp = nums.get(i);
                if(i>0 && nums.get(i) > prev)  nums.set(i, nums.get(i-1)+1);
                else    nums.set(i, 1);

                prev = temp;
            }

            for(int i=k-1; i+k<nums.size();i++){
                if(nums.get(i) >=k && nums.get(i+k) >= k) return true;

                // System.out.println(i+" "+(i+k));
            }

            return false;
    }
}