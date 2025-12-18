class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] prev = new int[26];
        int[] next = new int[26];

        Set<String> res = new HashSet<>();

        for(int i=1; i<s.length(); i++){
            next[s.charAt(i) - 'a']++;
        }
        prev[s.charAt(0) - 'a']++;

        for(int i=1; i<s.length()-1; i++){
            next[s.charAt(i) - 'a']--;

            for(int j=0; j<26; j++){
                if(prev[j] > 0 && next[j] > 0) 
                {

                    char outer = (char) ('a' + j);
                    char mid = s.charAt(i);
                    // Build a real string "outer mid outer"
                    res.add(new StringBuilder(3).append(outer).append(mid).append(outer).toString());

                }
            }

            prev[s.charAt(i) -'a'] ++;
        }

        return res.size();
    }
}