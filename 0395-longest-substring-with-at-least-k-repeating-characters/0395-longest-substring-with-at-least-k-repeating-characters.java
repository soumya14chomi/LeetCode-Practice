class Solution {
    public int longestSubstring(String s, int k) {

        int res =0;


        for(int i=0; i<s.length(); i++){
            HashMap<Character, Integer> hm = new HashMap<>();

            HashSet<Character> hs = new HashSet<>();

            for(int j=i; j<s.length(); j++){
                Character ch = s.charAt(j);
                hm.put(ch, hm.getOrDefault(ch, 0)+1);

                if(hm.get(ch) == k) hs.add(ch);

                if(hm.size() == hs.size())  res = Math.max(res, j-i+1);
            }
        }

        return res;
    }
}