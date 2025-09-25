class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int i =31;
        while(n>0){
            int temp = n%2;
            n = n/2;
            res+= temp*Math.pow(2, i--);
        }

        return res;
    }
}