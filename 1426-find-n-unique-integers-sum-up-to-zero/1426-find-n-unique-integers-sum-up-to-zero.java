class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx =0, i=1;
        if(n%2 !=0) res[idx++] = 0;
        while(idx<n){
            res[idx++] = i;
            res[idx++] = -1*i;
            i++;
        }

        return res;
    }
}