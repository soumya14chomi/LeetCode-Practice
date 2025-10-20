class Solution {
    public String fractionToDecimal(int n, int d) {

        String dec = "", frc = "";

        int sign = (n < 0 && d>0) || (n>0 && d<0) ? 1 : 0;

        long newN = Math.abs((long)n); long newD = Math.abs((long)d);

        frc+=String.valueOf(newN/newD);

        newN = (newN%newD)*10;

        HashMap<Long, Integer> hm = new HashMap<>();

        while(newN!=0){
            hm.put(newN, dec.length());

            // System.out.println(newN);
            while(newN<newD) {
                dec+="0";
                newN *=10;
            }
            dec+=String.valueOf(newN/newD);
            newN = (newN%newD) *10; 
            
            if(hm.containsKey(newN)){
                int idx = hm.get(newN);
                dec = dec.substring(0, idx)+"("+dec.substring(idx)+")";
                break;
            }
        }

        frc = sign == 1 ? "-"+frc : frc; 

        return dec.length() >0 ? frc+"."+dec: frc;
        
    }
}