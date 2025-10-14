class Solution {
    public int rangeBitwiseAnd(int l, int r) {
        int res = 0, count =0;

        while(l>0 || r>0){

            

            if((l&1) == (r&1))    res+=((l&1)<<count);
            else    res =0;

            count++;

            l = l>>1;
            r = r>>1;

            // System.out.println(l+" "+r+" "+res);

        }

        return res;
    }
}