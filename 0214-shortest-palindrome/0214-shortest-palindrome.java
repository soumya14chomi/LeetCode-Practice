class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;

        int[] lps = computeLPS(temp);
        int palLen = lps[temp.length() - 1];

        String suffix = s.substring(palLen);
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] computeLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;

        for (int i = 1; i < str.length(); i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
            }
        }

        return lps;
    }
}
