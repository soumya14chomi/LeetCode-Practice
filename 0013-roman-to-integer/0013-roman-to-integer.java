class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int res =0;
        int n = s.length();
        for(int i=0; i< n-1;i++){
            if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1)))  res-=hm.get(s.charAt(i));
            else    res+=hm.get(s.charAt(i));
        }

        res+=hm.get(s.charAt(n-1));
        return res;
    }
}