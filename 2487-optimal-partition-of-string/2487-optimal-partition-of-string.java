class Solution {
    public int partitionString(String s) {
        int res =0;

        for(int i=0; i<s.length();){
            int[] count = new int[26];

            while(i<s.length() && count[s.charAt(i) -'a'] ==0){
                count[s.charAt(i) - 'a']++;
                i++;
            }
            res++;
        }

        return res;
    }
}