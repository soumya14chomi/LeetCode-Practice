class Solution {
    public int countCollisions(String str) {
        int r = 0, s =0;

        int res = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'R')   r++;
            if(ch == 'S'){
                if(r > 0)   {
                    res+=r;r =0;
                }
                s++;
            }   

            if(ch == 'L'){
                if(r > 0){
                    res += (r+1);
                    r = 0;
                    s++;
                }
                else if(s>0){
                    // System.out.println("here");
                    res++;
                }
            }
        }

        return res;
    }
}