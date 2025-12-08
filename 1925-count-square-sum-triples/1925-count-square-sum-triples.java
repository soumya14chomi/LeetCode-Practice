class Solution {
    public int countTriples(int n) {
        
        int count =0;
        for(int i=1;i <= n; i++){
            for(int j= 1; j <=n; j++){
                int k = i*i + j*j;

                for(int p = j+1; p*p<= k && p<=n; p++){
                    if(p*p ==k) {
                        // System.out.println(i+" "+j + " "+p);
                        count++;
                    
                    }
                }
            }
        }

        return count;
    }
}