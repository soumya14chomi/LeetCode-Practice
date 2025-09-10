class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);

            if(!hm.containsKey(temp))   {
                hm.put(temp, new ArrayList<>());
            }
             hm.get(temp).add(strs[i]);

        }

        return new ArrayList<>(hm.values());
    
    }
}