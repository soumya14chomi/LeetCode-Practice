class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            int[] temp = new int[n];

            for(int j=0;j<=i;j++){
                if(j-1 < 0) temp[j] = dp[j]+triangle.get(i).get(j);
                else if(j>=i) temp[j] = dp[j-1] + triangle.get(i).get(j);

                else temp[j] = Math.min(dp[j], dp[j-1])+triangle.get(i).get(j);

                }

                System.out.println(Arrays.toString(temp));

                dp = temp;
     
        }

        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)    res = Math.min(res, dp[i]);

        return res;
    }
}