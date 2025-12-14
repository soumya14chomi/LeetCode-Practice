class Solution {
    public int numberOfWays(String corridor) {
        int  count =0, plantCount = 0, n = corridor.length();
        long res = 1;
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') totalSeats++;
        }
        // If total seats is zero or odd, it's impossible
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;


        for(int i=0; i<n; i++){

            if(corridor.charAt(i) == 'S')  count++;

            if(count == 2){
                i++;
                while(i<n && corridor.charAt(i) == 'P')   {
                    plantCount++;
                    i++;
                }

                // System.out.println(i+" "+plantCount);

                if(i<n){
                    // res = res ==0 ? 1: res;
                    res = ((long)(res * (plantCount+1)) %MOD);
                }
                i--;
                count =0;
                plantCount =0;
            }
        }
        return (int) (res % MOD);
    }
}