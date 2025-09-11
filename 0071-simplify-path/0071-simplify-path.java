import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/+");

        Deque<String> dq = new ArrayDeque<>();

        // System.out.println(Arrays.toString(folders));

        String res = "";

        for(int i=0; i<folders.length; i++){
            if(folders[i].isEmpty())   continue;
            if(folders[i].equals("..") ) {
                if(!dq.isEmpty())   dq.removeLast();
            }
                
            else if(folders[i].equals("."))  continue;
            else dq.addLast(folders[i]);
        }
        // System.out.println(dq.toString());
        while(dq.size()>0){
            res=res+"/"+dq.removeFirst();
        }

        return res.length() == 0 ? "/" : res; 
    }
}