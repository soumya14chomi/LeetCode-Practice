class Solution {
    public String longestPalindrome(String s) {
        // int res =0;
        String maxString = "";

        for(int i=0; i<s.length(); i++){
            String evenLen  = compute(s, i, 1);
            String oddLen = compute(s, i, 0);
            if(maxString.length() < evenLen.length()){
                maxString = evenLen;
            }
            if(maxString.length() < oddLen.length()){
                maxString = oddLen;
            }
        }

        return maxString;
    }

    String compute(String s, int i, int isEven){
        int idx1 = i, idx2 = i+isEven;

        for(; idx1>=0 && idx2<s.length(); idx1--, idx2++){
            if(s.charAt(idx1) != s.charAt(idx2)) break;
        }

          return s.substring(idx1+1, idx2);
    }
}