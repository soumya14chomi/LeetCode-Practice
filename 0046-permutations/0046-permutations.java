class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>());

        return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> arr){
        if(arr.size() == nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=0; i<nums.length ;i++){

            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
                helper(nums, res, arr);
                arr.remove(arr.size()-1);
            }

        }
    }
}

