class Solution {
    static List<Integer> lst;
    static{
        lst = new ArrayList();

        for(int i=1; i<1000000;i++){
         if(isValid(i)) lst.add(i);   
        }
        lst.add(1224444);
    }

    static boolean isValid(int num){

        int[] count = new int[9];

        while(num>0){
            if(num%10 == 0) return false; 
            count[num%10 -1]++;
            num = num/10;
        }

        for(int i=1; i<10; i++){
            if(count[i-1] !=0 && count[i-1]!=i) return false;
         }

         return true;

    }
    public int nextBeautifulNumber(int n) {
        return bsCeil(n);
    }

    int bsCeil(int n){
        int l = 0, r= lst.size()-1, res = r;

        while(l<=r){
            int mid = (l+r)/2;
            if(lst.get(mid) > n)    {
                res = mid;
                r = mid-1;
            }

            else    l = mid+1;
        }

        return lst.get(res);
    }


}