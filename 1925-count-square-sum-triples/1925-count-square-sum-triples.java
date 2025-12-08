class Solution {
    public int countTriples(int n) {
        
        int count =0;
        for(int i=1;i <= n; i++){
            for(int j= i+1; j <=n; j++){
                int k = i*i + j*j;
                int sqrt = (int)Math.sqrt(k);
                if(sqrt <=n && sqrt*sqrt == k )  count +=2;
                
            }
        }

        return count;
    }
}