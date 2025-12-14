class Solution {
    public List<String> validateCoupons(String[] code, String[] buss, boolean[] isActive) {
        List<String>[] coupons = new ArrayList[4];

        for(int i=0; i<4; i++){
            coupons[i] = new ArrayList<>();
        }

        for(int i =0; i<code.length; i++){

            if(isActive[i] && isValid(code[i])){
                if("electronics".equals(buss[i])){
                    coupons[0].add(code[i]);
                }
                else if("grocery".equals(buss[i])){
                    coupons[1].add(code[i]);
                }
                else if("pharmacy".equals(buss[i])){
                    coupons[2].add(code[i]);
                }
                else if(("restaurant".equals(buss[i]))) {
                    coupons[3].add(code[i]);
                }

            }
            
        }

        List<String> res = new ArrayList<>();

        for(int i=0; i<4; i++){
            Collections.sort(coupons[i]);
            res.addAll(coupons[i]);
        }

        return res;
    }

    
    boolean isValid(String s) {
        return s != null && !s.isEmpty() && s.matches("[A-Za-z0-9_]+");
    }

}