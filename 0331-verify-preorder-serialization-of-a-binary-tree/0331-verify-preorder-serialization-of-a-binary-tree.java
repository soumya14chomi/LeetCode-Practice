class Solution {
    int idx =0;
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");

        return  validate(strs) && idx == strs.length;
    }

    boolean validate(String[] strs){
        if(idx == strs.length)  return false;
        if(strs[idx].equals("#")){
            idx++;
            return true;
        }
        boolean res = true;
        idx++;
        res = res && validate(strs);
        // idx++;
        res = res && validate(strs);

        return res;
    }


}