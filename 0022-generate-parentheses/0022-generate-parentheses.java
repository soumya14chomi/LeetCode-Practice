class Solution {

    void helper(List<String> res, int open, int close, String s){
        if(open == 0 && close == 0) {
         res.add(s);
         return;   
        }
        if(open > 0)    helper(res, open-1, close, s+"(");
        if(close > 0 && open < close) helper(res, open, close-1, s+")");
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(res, n, n, "");
        return res;
    }
}