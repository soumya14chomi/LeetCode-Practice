class Solution {
    public int hIndex(int[] arr) {
        int res = arr.length;
        for(int i=arr.length-1; i>=0; i--){
            // System.out.println(arr[i] + " "+(arr.length-i));
            if(arr[i]!=0 && arr[i] == arr.length-i) return arr.length-i;
            else if(arr[i] > arr.length-i)  res = i;
        }

        return arr.length-res;
    }
}