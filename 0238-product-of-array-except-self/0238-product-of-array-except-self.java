class Solution {
    public int[] productExceptSelf(int[] nums) {

        int left[] = new int[nums.length+1];
        int right[] = new int[nums.length+1];

        left[0] = 1;
        right[nums.length] = 1;

        for(int i=1; i<nums.length ; i++){
            left[i] = left[i-1] * nums[i-1];
            right[nums.length-i] = right[nums.length - i +1] * nums[nums.length-i];

            System.out.println((nums.length-i) +" "+right[nums.length-i]+ " * " + i+" "+left[i]);
            
        }

    

        int[] res = new int[nums.length];

        for(int i=1;i<nums.length;i++){
            res[i] = left[i] * right[i+1];
        }

        res[0] = right[1];
        return res;
    }
}