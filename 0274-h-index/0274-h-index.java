class Solution {
    public int hIndex(int[] arr) {
        int[] count = new int[arr.length+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= arr.length)    count[arr.length]+=1;
            else    count[arr[i]]+=1;
        }
        int res = 0;
        for(int i=arr.length; i>=0; i--){
            res+=count[i];
            if(res>=i)  return i;
        }

        return -1;
    }
}