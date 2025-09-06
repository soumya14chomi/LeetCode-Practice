class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> hs = new HashSet<>();
        int l=0, r=0, max=1;
        hs.add(s.charAt(0));

        for(;r<s.length()-1;r++){
            while(hs.contains(s.charAt(r+1))){
                hs.remove(s.charAt(l));
                l++;    
            }
            hs.add(s.charAt(r+1));
            max = Math.max(max, hs.size());
            //  System.out.println(hs.toString() +" "+l+" "+r);

        }

        return max;

        
    }
}