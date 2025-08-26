class Solution {
    public int removeDuplicates(int[] arr) {
    
        if(arr.length <=2)   return arr.length;
        int i=0;
        int curr = 0;
        int n = arr.length;
        for(;i<n;i++){
            if(arr[i] == arr[curr] && i-curr>=2){
                arr[i] = Integer.MAX_VALUE;
            }
            else if(arr[i]!=arr[curr])   curr=i;
        }

        System.out.println(arr);
        curr=0;
        i=0;
        while(i<n && arr[i]!=Integer.MAX_VALUE) i++;
        if(i==n)    return arr.length;
        curr=i;
        for(;i<n;i++){
            if(arr[i] != Integer.MAX_VALUE){
                arr[curr] = arr[i];
                arr[i] = Integer.MAX_VALUE;
                curr++;
            }
        }
        return curr;   
    }

}