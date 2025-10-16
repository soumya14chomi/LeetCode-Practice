class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res =new ArrayList<>();

        // HashSet<String> hs = new HashSet<>();
        Arrays.sort(nums);

        int n= nums.length;

        if(nums[0] == nums[n-1])    {
            if(nums[0] == 0)   res.add(List.of(0, 0, 0));
             return res;
        }

        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1])    continue;

            for(int j=i+1, k = n-1; j < k ; ){
                
                if(j> i+1 && nums[j] == nums[j-1])  {
                    j++;
                    continue;
                }
                if(k<n-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }

                if(-nums[i] == nums[j] + nums[k]){

                   
                res.add(List.of(nums[i], nums[j], nums[k]));
                j++;
                k--;
                // hs.add(str);

                }

                else{
                    if(nums[j] + nums[k] > -nums[i])    k--;
                    else j++;
                }

            }
        }

        return res;
        
    }
}