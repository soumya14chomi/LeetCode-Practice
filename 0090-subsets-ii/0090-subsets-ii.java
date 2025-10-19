class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    void helper(int[] nums, int i, List<Integer> arr, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[i]);
        helper(nums, i+1, arr, res);
        arr.remove(arr.size()-1);

        while(i<nums.length-1 && nums[i] == nums[i+1])    i++;

        helper(nums, i+1, arr, res);
        
    }


}