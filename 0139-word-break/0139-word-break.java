class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> hs= new HashSet<>();

        for(int i=0; i<wordDict.size(); i++)    hs.add(wordDict.get(i));
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i < s.length()+1; i++){
            for(int j=i-1; j>=0; j--){
                if(dp[j] && hs.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}