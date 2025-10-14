class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(hs.contains(nums[i]))   hs.remove(nums[i]);
            else    hs.add(nums[i]);
        }
        int[] res = new int[2];
        int idx =0;
        for(Integer i: hs)  res[idx++] = i;

        return res;
    }
}