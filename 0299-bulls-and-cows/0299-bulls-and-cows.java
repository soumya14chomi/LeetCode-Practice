class Solution {
    public String getHint(String secret, String guess) {
        int res1 = 0, res2 =0;

        int[] count = new int[10];

        for(int i=0; i<secret.length();i++)  count[secret.charAt(i) - '0']++;

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                count[secret.charAt(i) - '0']--;
                res1++;
            }
        }

        for(int i=0; i<guess.length(); i++){
            if(count[guess.charAt(i) - '0']>0 && secret.charAt(i) != guess.charAt(i))  {
                count[guess.charAt(i) - '0']--;
                res2++;
            }
        }

        return String.valueOf(res1)+"A"+String.valueOf(res2)+"B";
    }
}