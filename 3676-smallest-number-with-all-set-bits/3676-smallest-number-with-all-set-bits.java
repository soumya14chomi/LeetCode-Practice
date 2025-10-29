class Solution {
    public int smallestNumber(int n) {
        int res = 0;

        do{
            res = (res<<1)+1;
            System.out.println(res);
            n = n/2;
        }
        while(n>0);

        return res;
    }
}