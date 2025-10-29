class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        helper(num, target, "",0, res, "" );

        return res;
    }

    void helper(String num, int target, String str, int idx, List<String> res, String str1){

        if(idx == num.length()){

            long val = eval(str);
            // System.out.println(str+" "+val);
            if(target == val){
                res.add(str);
            }

            return;
        }
        char ch = num.charAt(idx);
        if(idx!=0){
            helper(num, target, str+"*"+ch, idx+1, res, ""+ch);
             helper(num, target, str+"+"+ch, idx+1, res, ""+ch);
            helper(num, target, str+"-"+ch, idx+1, res, ""+ch);
        }

        if(str1.length() == 0 || str1.charAt(0)!='0' )
            helper(num, target, str+num.charAt(idx), idx+1, res, str1+ch);

        
        

    }

    long eval(String str){
        char op = '+';
        long val = 0 ;


        Stack<Long> st = new Stack<>();

        for(int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9'){
                val = val*10+((int)ch - '0');
            }

            if(ch == '+' || ch == '-' || ch == '*' || i == str.length()-1){
                if(op == '+'){
                    st.push(val);
                }
                else if(op == '-'){
                    st.push(-val);
                }
                else{
                    st.push(st.pop() * val);
                }

                op = ch;
                val =0;
            }

        }

        val = 0;

        while(!st.isEmpty()){
            val+=st.pop();
        }

        return val;

    }
}