class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res, new ArrayList<>(), target, 0);

        return res;
    }

    void helper(int start, int[] nums, List<List<Integer>> res, List<Integer> arr, int target, int sum){
        if(target == sum){
            res.add(new ArrayList<>(arr));
            return;
        }

        if(sum>target)  return;


        for(int i=start; i<nums.length;i++){
            arr.add(nums[i]);
            helper(i, nums, res, arr, target, sum+nums[i]);
            arr.remove(arr.size()-1);
        }
    }
}