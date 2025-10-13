class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev = "";

        List<String> res = new ArrayList<>();

        for(int i=0; i<words.length; i++){

            char[] charArray = words[i].toCharArray();

            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if(!sortedString.equals(prev)) res.add(words[i]);

            prev = sortedString;

        }

        return res;
    }
}