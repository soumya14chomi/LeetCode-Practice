class Solution {
    public int minCost(String colors, int[] arr) {
        int res = 0;
        int prev = arr[0];
        for(int i=1; i<arr.length; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                if(arr[i]>prev){
                    res+=prev;
                    prev = arr[i];
                }
                else{
                    res+=arr[i];
                }
            }
            else{
                prev = arr[i];
            }

            // System.out.println(prev);
        }
        return res;
    }
}