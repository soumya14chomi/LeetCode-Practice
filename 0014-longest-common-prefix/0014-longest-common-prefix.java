class Solution {
    public String longestCommonPrefix(String[] strs) {

        String res = strs[0];
        int n = res.length();
        int i=1;

        while(i<strs.length && res.length() > 0){
            // System.out.println(res+" "+strs[i]);
            if(res.length() > strs[i].length()){
                res = res.substring(0, strs[i].length());
            }
            strs[i] = strs[i].substring(0, res.length());
            if(res.equals(strs[i])) {
                i++;
            }
            else{
            res = res.substring(0, res.length()-1);
            strs[i] = strs[i].substring(0, res.length());
            //  System.out.println(res+" "+strs[i]);
            }


        }

        return res;

    }
}