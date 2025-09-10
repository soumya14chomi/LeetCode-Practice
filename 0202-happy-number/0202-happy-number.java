class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();

        while(n!=1){
            if(hs.contains(n))  return false;
            hs.add(n);
            int temp = n, res=0;
            while(temp>0){
                res+=Math.pow((temp%10), 2);
                temp = temp/10;
            }
            n = res;
        }


        return true;
    }
}