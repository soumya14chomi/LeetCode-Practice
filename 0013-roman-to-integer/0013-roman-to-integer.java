class Solution {
        static Map<Character, Integer> hm = new HashMap<>();
        Solution(){
            hm.put('I', 1);
            hm.put('V', 5);
            hm.put('X', 10);
            hm.put('L', 50);
            hm.put('C', 100);
            hm.put('D', 500);
            hm.put('M', 1000);
        }

    public int romanToInt(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();



        int res=0;
        for(int i=0; i<n;i++){
            if(st.isEmpty())    st.push(hm.get(s.charAt(i)));
            else if(st.peek() < hm.get(s.charAt(i))) {
                int val = st.pop();
                st.push(hm.get(s.charAt(i))-val);
                

            }
            else {
                st.push(hm.get(s.charAt(i)));
            }

            // System.out.println(st.toString());
        }

        while(!st.isEmpty()){
            res+=st.pop();
        }

        return res;
    }
}