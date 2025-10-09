class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();

        Arrays.sort(arr);

        helper(arr, target, "", res, hs, 0, new ArrayList<>(), 0);

        return res;
    }

    void helper(int[] arr, int target, String str, List<List<Integer>> res, HashSet<String> hs,  int sum, List<Integer> lst, int idx){

        if(sum == target && !hs.contains(str)){
             res.add(new ArrayList<>(lst));
             hs.add(str);
        }

        // System.out.println(lst);

        if(sum >= target || idx == arr.length)   return;

        lst.add(arr[idx]);
        helper(arr, target, str+","+arr[idx], res, hs, sum+arr[idx], lst, idx+1);
        lst.remove(lst.size()-1);

        while(idx<arr.length-1 && arr[idx] == arr[idx+1])   idx++;

        helper(arr, target, str, res, hs, sum, lst, idx+1);

    }
}