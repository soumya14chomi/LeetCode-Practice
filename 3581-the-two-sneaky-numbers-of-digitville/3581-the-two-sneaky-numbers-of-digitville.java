class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];

        for(int i=0; i<nums.length; i++)    nums[i]+=1;

        for(int i=0; i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0) {
                if(res[0] == 0) res[0] = idx;
                else    res[1] = idx;
            }
            else{
                nums[idx] = -nums[idx];
            }
        }

        return res;
    }
}