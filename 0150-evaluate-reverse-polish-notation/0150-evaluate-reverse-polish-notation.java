class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        HashSet<String> hs = new HashSet<>(List.of("+", "-", "*", "/"));
        for(int i=0; i<tokens.length; i++){
            
                if(tokens[i].equals("+")) st.push(st.pop()+st.pop());
                else if(tokens[i].equals("-")) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    st.push(num2 - num1);
                }
                else if(tokens[i].equals("*")) st.push(st.pop() * st.pop());
                else if(tokens[i].equals("/")) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    st.push(num2 / num1);
                }
                else st.push(Integer.parseInt(tokens[i]));

            // System.out.println(st.peek());
            }
                

        return st.pop();
    }
}