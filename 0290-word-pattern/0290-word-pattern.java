class Solution {
    public boolean wordPattern(String p, String s) {

        String[] words = s.split(" ");
        if(p.length() != words.length)  return false;
        Map<Character, String> hm= new HashMap<>();
        Map<String, Character> hm1 = new HashMap<>();

        for(int i=0; i<p.length(); i++){
            if(!hm.containsKey(p.charAt(i)) && !hm1.containsKey(words[i]))   {
                hm.put((Character)p.charAt(i), words[i]);
                hm1.put(words[i], (Character) p.charAt(i));
            }

            else if( words[i].equals(hm.get(p.charAt(i))) && p.charAt(i) == (hm1.get(words[i]))) continue;
            else    return false;
        }

        return true;

    }
}