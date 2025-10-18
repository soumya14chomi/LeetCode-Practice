class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        HashSet<Long> hs = new HashSet<>();
        Arrays.sort(nums);


        long prev = (long)nums[0] - k;

        for(int i=0; i<nums.length; i++){
            prev = Math.max(nums[i] - k, prev);

            while(prev<= (long)nums[i] + k && hs.contains(prev))    prev++;

            if(prev<=(long)nums[i] + k) {
                hs.add(prev);
            }
        }

        return hs.size();
    }
}