class Solution {
    public int minNumberOperations(int[] target) {
        Stack<Integer> st = new Stack<>();
        int n = target.length;
        int[] left = new int[n];

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && target[st.peek()] > target[i])  st.pop();
            if(st.isEmpty())    left[i] = 0;
            else left[i] = target[st.peek()];

            st.push(i);
        }

        int res =0;
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && target[st.peek()] >= target[i])  st.pop();

            if(st.isEmpty())    {
                res +=(target[i] - left[i]);
            }
            else{
                res+=(target[i] - Math.max(left[i], target[st.peek()]));
            }

            st.push(i);

        }

        return res;
    }
}