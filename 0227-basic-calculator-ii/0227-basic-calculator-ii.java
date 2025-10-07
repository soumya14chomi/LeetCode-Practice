class Solution {
    public int calculate(String s) {
        int i =0, res =0;
        Stack<Integer> st = new Stack<>();
        char sign = '+';
        while(i < s.length()){
            char ch = s.charAt(i);

            if(Character.isDigit(s.charAt(i))) {
                res = res*10 + (s.charAt(i) - '0');
            }
             if(ch == '+' || ch == '-' || ch == '*' || ch =='/' || i == s.length()-1){
                if(sign ==  '+'){
                    st.push(res);
                }
                else if(sign == '-'){
                    st.push(-1*res);
                }
                else if(sign == '*'){
                    // System.out.println("here");
                    int val = st.pop();
                    res = val * res;
                    st.push(res);
                }
                else if(sign == '/'){
                    int val = st.pop();
                    res = val/res;
                    st.push(res);
                }
                sign = ch;
                res = 0;
            }
            i++;

        // System.out.println(st.toString());
        }
    
        res =0;
        while(!st.isEmpty())    res+=st.pop();

        return res;
    }
}