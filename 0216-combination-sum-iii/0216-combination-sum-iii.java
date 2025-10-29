class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, new ArrayList<>(), res, k, n, 0);

        return res;
    }

    void helper(int num, List<Integer> lst, List<List<Integer>> res, int k, int n, int total){
        if(lst.size() == k){
            if(total == n)  res.add(new ArrayList<>(lst));

            return;
        }
         if(num ==10)    return;

        // System.out.println(lst.toString());
        helper(num+1, lst, res, k, n, total);
        if(total + num <= n && lst.size() < k){
            lst.add(num);
            helper(num+1, lst, res, k, n, total+num);
            lst.remove(lst.size()-1);
        }
        
    }
    

}