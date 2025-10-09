class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        

        helper(nums, res, new ArrayList<>(), new HashSet<>());

        return res;
    }

    void helper(int[] nums, List<List<Integer>> res, List<Integer> lst, Set<Integer> hs){

        if(hs.size() == nums.length){
            res.add(new ArrayList<>(lst));
            return;
        }


        // System.out.println(lst);

        for(int i=0; i<nums.length; i++){
            if(hs.contains(i) ||  (i>0 && nums[i] == nums[i-1] && hs.contains(i-1))) continue;
            lst.add(nums[i]);
            hs.add(i);
            helper(nums, res, lst, hs);
            lst.remove(lst.size()-1);
            hs.remove(i);
        }

    }




}