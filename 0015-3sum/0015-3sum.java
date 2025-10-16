class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res =new ArrayList<>();

        HashSet<String> hs = new HashSet<>();
        Arrays.sort(nums);

        int n= nums.length;

        for(int i=0; i<n; i++){
            for(int j=i+1, k = n-1; j < k ; ){

            String str = nums[i]+","+nums[j]+","+nums[k];
            
            if(hs.contains(str))
            {
                    j++;
                    k--;
                    continue;
            }

                if(-nums[i] == nums[j] + nums[k]){

                   
                res.add(List.of(nums[i], nums[j], nums[k]));
                j++;
                k--;
                hs.add(str);

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