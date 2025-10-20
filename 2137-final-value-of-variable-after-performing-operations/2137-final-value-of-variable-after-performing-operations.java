class Solution {
    public int finalValueAfterOperations(String[] arr) {
        int res = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i].equals("++X") || arr[i].equals("X++"))    res++;
            else    res--;
        }

        return res;
    }
}