class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n =nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);

        int max = 0;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i] % nums[j] ==0 && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
           

            if(dp[max] < dp[i]) max = i;
            //  System.out.println(Arrays.toString(prev)+ " "+max);

        }
        List<Integer> lst = new ArrayList<>();

        for(int i=max; i!=-1; i = prev[i]){
            lst.add(nums[i]);
        }

        return lst;
    }
}