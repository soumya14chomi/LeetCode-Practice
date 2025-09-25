class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int i =31;
        while(n>0){
            int temp = n%2;
            n = n/2;
            res+= temp* (1<<i);
            i--;
        }

        return res;
    }
}