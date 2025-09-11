class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')  st.push(')');
            else if(s.charAt(i)== '[')  st.push(']');
            else if(s.charAt(i) == '{') st.push('}');
            else {
                if(st.isEmpty() || st.peek()!=s.charAt(i)) return false;
                st.pop();
            }
        }

        if(st.isEmpty())    return true;
        return false;
    }
}