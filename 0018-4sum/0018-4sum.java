class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        for(int i=0; i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n; j++){

                if(j>i+1 && nums[j] == nums[j-1])   continue;

                long newVal = (long) target - nums[i] - nums[j];

                System.out.println(newVal);

                for(int l = j+1, r = n-1; l<r;){
                    if(l>j+1 && nums[l] == nums[l-1]){
                        l++;
                        continue;
                    }   
                    if(r<n-1 && nums[r] == nums[r+1]){
                        r--;
                        continue;
                    }

                    if(nums[l] + nums[r] == newVal)  {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    }
                    else if(nums[l] + nums[r] < newVal)  l++;
                    else r--;


                }
            }   
        }

        return res;
    }
}