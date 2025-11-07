class Solution {
    public void wiggleSort(int[] nums) {

        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);

        Arrays.sort(temp);

        int idx =0, mid = n%2 == 0? n/2-1 : n/2;

        for(int i=n-1, j = mid; idx < n; i--, j--){
            

            if(idx+1< n) nums[idx+1] = temp[i];
            nums[idx] = temp[j];
            idx = idx+2;
        }    

    }
}