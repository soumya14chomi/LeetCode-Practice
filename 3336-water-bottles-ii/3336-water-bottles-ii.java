class Solution {
    public int maxBottlesDrunk(int b, int e) {
        int res  = b;

        while(b >= e){
            b = b-e+1;
            res++;
            e++;
        }

        return res;
    }
}