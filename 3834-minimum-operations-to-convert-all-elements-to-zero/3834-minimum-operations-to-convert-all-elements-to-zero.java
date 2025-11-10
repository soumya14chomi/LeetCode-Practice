class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Pair<Integer, Integer>> hm = new HashMap<>();

        int res = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] ==0){
                st.clear();
                st.push(i);
                continue;
            }
            while(!st.isEmpty() && nums[st.peek()] >= nums[i])  {
                st.pop();
            }

            int smallest = st.isEmpty() ? -1 : st.peek();
            if(!hm.containsKey(nums[i]) || hm.get(nums[i]).getValue() != smallest){
                hm.put(nums[i], new Pair(i, smallest));
                res++;
            }
            
            st.push(i);
            
        }

        return res;
    }
}