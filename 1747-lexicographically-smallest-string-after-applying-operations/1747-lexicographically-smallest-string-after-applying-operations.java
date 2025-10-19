class Solution {
    String res = "";
    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> hs = new HashSet<>();
        this.res = s;
        // hs.add(s);
        recursion(s, a, b, hs);
        return res;
    }

    void recursion(String s, int a, int b, HashSet<String> hs){

        if(hs.contains(s)) return;

        if(res.compareTo(s) > 0) res = s;

        hs.add(s);

        recursion(addOdd(s, a), a, b, hs);

        recursion(rotate(s, b), a, b, hs);

    }

    String addOdd(String s, int a){

        char[] ch = s.toCharArray();

        for(int i=1; i<s.length(); i=i+2){

            ch[i] = (char)(((int)(ch[i]-'0') + a)%10 + '0');

        }

        return new String(ch);

    }

    String rotate(String s, int b){

        int n = s.length();

        char[] ch = new char[n];
        for(int i=0; i<n; i++){
            ch[i] = s.charAt((i+b)%n);
        }

        return new String(ch);

    }

}