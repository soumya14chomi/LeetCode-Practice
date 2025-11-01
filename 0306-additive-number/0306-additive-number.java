class Solution {
    public boolean isAdditiveNumber(String num) {

        if(num.length()<3)   return false;

        int n = num.length();

        for(int i=1; i<=(n-1)/2; i++){
            for(int j=i+1; n-j>=j-i && n-j>=i; j++){

                if(isValidNum(num, 0, i) && isValidNum(num, i, j)){
                    if(isValid(num, 0, i, j))   return true;
                }
               
            }
        }

        return false;
    }

    boolean isValid(String num, int idx1, int idx2, int idx3){
        
        if(idx3<num.length()){
            long num1 = Long.parseLong(num.substring(idx1, idx2));
            long num2 = Long.parseLong(num.substring(idx2, idx3));
            String sum = String.valueOf(num1+num2);
            if(idx3+sum.length() <= num.length() && num.substring(idx3, idx3+sum.length()).equals(sum)){
                System.out.println(num1+" "+num2+" "+sum);
                return isValid(num, idx2, idx3, idx3+sum.length());
            }
            else    return false;
        }   

        return true;
    }

    boolean isValidNum(String num, int i, int j){
        if(j-i == 1)    return true;

        return num.charAt(i)!='0';

    }


}