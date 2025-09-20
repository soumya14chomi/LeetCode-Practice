class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, n, k, res, new ArrayList<>());
        return res;
    }

    void helper(int s, int end, int k, List<List<Integer>> res, List<Integer> arr){
        if(arr.size() == k){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i=s; i<end; i++){
            arr.add(i+1);
            helper(i+1, end, k, res, arr);
            arr.remove(arr.size()-1);
        }
    }
}