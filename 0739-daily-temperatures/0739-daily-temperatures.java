class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<int[]> st = new Stack<>();

        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()[1] <= nums[i])  st.pop();

            int temp = 0;
            if(!st.isEmpty())   temp = st.peek()[0]-i;

            st.push(new int[]{i, nums[i]});
            nums[i] = temp;
        }

        return nums;
    }
}