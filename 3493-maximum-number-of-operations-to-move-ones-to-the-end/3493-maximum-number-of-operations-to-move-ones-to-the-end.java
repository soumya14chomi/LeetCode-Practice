class Solution {
    public int maxOperations(String s) {
        int gaps =0, res =0;

        for(int i=s.length()-1; i>=0; i--){
            if(i>0 && s.charAt(i) == '0' && s.charAt(i-1) == '1')   gaps++;
            else if(s.charAt(i) == '1') res+=gaps;
        }

        return res;
    }
}