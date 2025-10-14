class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        Queue<String> qu = new LinkedList<>();

        List<String> res = new ArrayList<>();

        qu.add(s);

        

        while(!qu.isEmpty()){

            if(res.size() > 0)  break;

            int size = qu.size();

            Set<String> level = new HashSet<>();

            for(int idx=0; idx<size; idx++)            
            {    
                String str = qu.poll();


                if(isValid(str)){
                    res.add(str);
                    continue;
                }

                for(int i=0; i<str.length(); i++){
                    if(str.charAt(i)!='(' && str.charAt(i)!=')')    continue;

                    if(i>0 && str.charAt(i) == str.charAt(i-1)) continue;

                    String next = (str.substring(0, i) + str.substring(i+1));

                    if(!level.contains(next)){
                        qu.add(next);
                        level.add(next);
                    }  

                    // System.out.println(str.substring(0, i) + str.substring(i+1));
                }
            }

        }

        return res;
    }

    boolean isValid(String str){
        int count = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(')    count++;
            if(str.charAt(i) == ')')    count--;

            if(count<0) return false;
        }

        if(count == 0){
            System.out.println(str);
            return true;
        }

        return count == 0;
    }
}