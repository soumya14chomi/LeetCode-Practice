class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, Set<Character>> hm = new HashMap<>();

        hm.put('2', Set.of('a', 'b', 'c'));
        hm.put('3', Set.of('d', 'e', 'f'));
        hm.put('4', Set.of('g', 'h', 'i'));
        hm.put('5', Set.of('j', 'k', 'l'));
        hm.put('6', Set.of('m', 'n', 'o'));
        hm.put('7', Set.of('p', 'q', 'r', 's'));
        hm.put('8', Set.of('t', 'u', 'v'));
        hm.put('9', Set.of('w', 'x', 'y', 'z'));

        

        List<String> res = new ArrayList<>();

        recursion(digits, 0, hm, res, "");

        return res;
    }

    void recursion(String digits, int idx,  Map<Character, Set<Character>> hm, List<String> res, String str){

        if(idx == digits.length()){
            if(!str.isEmpty()) res.add(str);
            return;
        }
        // if(!hm.containsKey(digits.charAt(idx)))    return;
        for(Character ch : hm.get(digits.charAt(idx))){
            str+=ch;
            recursion(digits, idx+1, hm, res, str);
            str = str.substring(0, str.length()-1);
        }

    }
}