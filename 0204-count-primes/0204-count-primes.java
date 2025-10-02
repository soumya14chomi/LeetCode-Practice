class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0;

        boolean[] cons = new boolean[n];

        cons[0] = true; cons[1] = true;

        for(int i=2; i<=n/2; i++){
            int idx =2;
            while(i*idx < n)    {
                cons[i*idx] = true;
                idx++;
            }
        }
        // System.out.println(Arrays.toString(cons));
        int res = 0;
        for(int i=2; i<n; i++){
            if(!cons[i])    res++; 
        }

        return res;
    }
}