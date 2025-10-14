import java.math.BigInteger;

class Solution {
    public String multiply(String nums1, String nums2) {
        BigInteger prev = new BigInteger("0");
        BigInteger superTens = new BigInteger("1");

        for(int i=nums1.length()-1;i>=0;i--){

            BigInteger curr = new BigInteger("0");
            int carry = 0;
            BigInteger tens = BigInteger.valueOf(1);
            
            int ch1 = nums1.charAt(i) - '0';

            for(int j = nums2.length()-1; j>=0; j--){

                int ch2 = nums2.charAt(j) - '0';

                if( j == nums2.length()-1){
                    carry = (ch1*ch2)/10;
                    curr = BigInteger.valueOf((ch1*ch2)%10);
                }   
                else{
                    int temp = (ch1*ch2 + carry)/10;
                    curr = curr.add(tens.multiply(BigInteger.valueOf((ch1*ch2 + carry)%10)));
                    carry = temp;

                }
                tens = tens.multiply(BigInteger.valueOf(10));
            }

            curr = curr.add(tens.multiply(BigInteger.valueOf(carry)));
            prev = prev.add(curr.multiply(superTens));
            
            superTens= superTens.multiply(BigInteger.valueOf(10));

            // System.out.println(curr+" "+prev);
        }

        return String.valueOf(prev);
    }
}