class Solution {
    public int countPalindromicSubsequence(String s) {

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first,-1);
        Arrays.fill(last, -1);

        int res =0;

        for(int i=0; i<s.length(); i++){

            int ch = s.charAt(i) - 'a';

            if(first[ch] == -1){
                first[ch] = i;
            }
            last[ch] = i;
        }


        for(int i=0; i<26; i++){
            if(first[i] != last[i]){
                // res+= (prefix[last[i]] - prefix[first[i]] );

                Set<Character> count = new HashSet<>();
                for(int j = first[i] +1; j<last[i]; j++){
                    // System.out.println("Adding:" + s.charAt(j));
                    count.add(s.charAt(j));
                }

                res+=(count.size());
            }
        }

        return res;
    
    }
}