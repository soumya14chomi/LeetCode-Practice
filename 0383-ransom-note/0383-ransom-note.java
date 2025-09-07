class Solution {
    public boolean canConstruct(String r, String m) {
        if(r.length() > m.length()) return false;
        int[] count = new int[26];

        for(int i=0; i<m.length(); i++) count[m.charAt(i) - 'a']++;

        for(int i=0;i<r.length(); i++){
            count[r.charAt(i)-'a']--;
            if(count[r.charAt(i) - 'a'] < 0)    return false;
        }
        return true;
    }
}