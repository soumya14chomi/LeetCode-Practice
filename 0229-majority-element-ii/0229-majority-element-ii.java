class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==1)  return List.of(nums[0]);
        int count1 = 0, num1 = Integer.MIN_VALUE;
        int count2 = 0, num2 = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i=0;i <nums.length; i++){
            if(num1 == Integer.MIN_VALUE && nums[i] !=num2)  num1 = nums[i];
            if(num2== Integer.MIN_VALUE) num2 = nums[i];
            if(nums[i] == num2){
                count2++;
            }
            else if(nums[i] == num1){
                count1++;
            }

            else if(count1 == 0) {
                count1 =1;
                num1 = nums[i];
            }
            else if(count2 == 0){
                count2 = 1;
                num2 = nums[i];
            }

            else{
                count1--;
                count2--;
            }

        }

         count1=0; count2 = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
        }

        // System.out.println(num1+" "+num2);

        List<Integer> res = new ArrayList<>();

        if(count1> n/3) res.add(num1);
        if(count2> n/3) res.add(num2);

        return res;
    }
}