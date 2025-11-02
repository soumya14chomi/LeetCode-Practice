// import org.apache.commons.lang3.StringUtils;

class Solution {
    public String reverseWords(String s) {
        s= s.strip();
        String[] strs = s.split(" ");
        s = "";
        for(int i=strs.length-1; i>=0; i--){
            // System.out.println(isNotBlank(strs[i]));
            if(isNotBlank(strs[i]))  {
                s+=strs[i].trim();
                if(i!=0)    s+=" ";
            }  
            
        }

        return s;
    }

    public static boolean isNotBlank(String str) {
        return str != null && str.length()>0 && !str.trim().isEmpty();
    }
}