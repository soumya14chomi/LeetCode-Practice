class Solution {
    public String smallestSubsequence(String s) {

       Stack<Integer> st = new Stack<>();
       boolean[] visited = new boolean[26];

       int[] freq = new int[26];

       for(int i=0; i<s.length(); i++)  freq[s.charAt(i)-'a']++;

        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';

            freq[ch]--;
            if(visited[ch])  continue;


            while(!st.isEmpty() && st.peek() >= ch && freq[st.peek()] > 0){
                visited[st.pop()] = false;
            }
            // System.out.println(st.toString());


            visited[ch] = true;
            st.push(ch);
        }
        s ="";
        while(!st.isEmpty()){
            s=((char)(st.pop() + 'a'))+s;
        }

        return s;
        
    }
}