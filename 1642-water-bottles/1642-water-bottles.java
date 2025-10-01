class Solution {
    public int numWaterBottles(int n, int d) {
        int res=n;

        while(n>=d){
            res += n/d;
            int carry = n%d;
            n = n/d + carry;
        }

        return res;
    }
}