class Solution {
    public int totalMoney(int n) {
        int sum = 0, idx =0, week = 0;

        while(idx<n){
            week++;
            for(int i=0;i<7&&idx<n;i++){
                sum+=(week+i);
                idx++;
            }
        }

        return sum;
    }
}