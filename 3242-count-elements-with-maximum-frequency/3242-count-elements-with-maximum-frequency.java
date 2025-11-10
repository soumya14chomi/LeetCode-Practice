class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFreq = 0, res=0;
        for(int i=0; i<nums.length; i++)  {
              count[nums[i]]++;
              if(maxFreq < count[nums[i]]) {
                    maxFreq = count[nums[i]];
                    res = count[nums[i]];
              } 
              else if (maxFreq == count[nums[i]])  {
                
                res= res+ count[nums[i]];
                // System.out.println(nums[i] + " "+maxFreq+" "+count[nums[i]]+" "+res);
              }  

            }

              return res;

    }
}