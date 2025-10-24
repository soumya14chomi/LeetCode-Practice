class Solution {
    public boolean hasSameDigits(String s) {

        while(s.length() > 2){
            String temp = "";

            for(int i=1; i<s.length(); i++){
                temp+=String.valueOf(
                    ((((int)s.charAt(i) - '0') +
                    (int)s.charAt(i-1) - '0'))%10
                );
            }

            s = temp;
        
        }

        return s.charAt(0) == s.charAt(1);
    }
}