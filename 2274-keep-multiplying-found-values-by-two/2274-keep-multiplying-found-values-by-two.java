class Solution {
    public int findFinalValue(int[] nums, int org) {
        Arrays.sort(nums);

        int res = -1;

        do{
            res = bst(nums, org, res == -1? 0 : res);
            org = org*2;

        }
        while(res!=-1);

        return org/2;
    }

    int bst(int[] nums, int target, int l){
        int r = nums.length-1;

        while(l<=r){
            int mid= (l+r)/2;
            if(nums[mid] == target)    return mid;
            if(nums[mid] < target)    l = mid+1;
            else    r = mid-1;
        }

        return -1;
    }
}