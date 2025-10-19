class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), res, new HashSet<>());
        return res;
    }
    void helper(int[] nums, int i, List<Integer> arr, List<List<Integer>> res, HashSet<String> hs){
        if(i == nums.length){
            if(hs.contains(arr.toString())) return;
            hs.add(arr.toString());
            res.add(new ArrayList<>(arr));
            return;
        }

        // System.out.println(arr.toString());

        helper(nums, i+1, arr, res, hs);
        // if(i>0 && nums[i] == nums[i-1] ) return;

        arr.add(nums[i]);
        // hs.add(nums[i]);
        helper(nums, i+1, arr, res, hs);
        arr.remove(arr.size()-1);
        // hs.remove(nums[i]);
             
    }

}