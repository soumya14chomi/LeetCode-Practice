class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int['z' - 'A'+1];

        for(int i=0; i<t.length();i++)  count[t.charAt(i)-'A']++;
        int[] count2 = new int['z' - 'A'+1];

        int l=0;
        String res = s+t;
        for(int i=0;i<s.length();i++){
            count2[s.charAt(i)-'A']++;
            while(isSubString(count, count2)){
                // System.out.println("here");
                res = res.length() <  i-l+1 ? res : s.substring(l, i+1);
                count2[s.charAt(l++)-'A']--;
            }
        }

        return res.length() == s.length()+t.length() ? "" :  res;
    }

    boolean isSubString(int[] count, int[] count2){
        for(int i=0; i<'z' - 'A'+1; i++){
            if(count2[i] < count[i])    return false;
        }
        return true;
    }
}