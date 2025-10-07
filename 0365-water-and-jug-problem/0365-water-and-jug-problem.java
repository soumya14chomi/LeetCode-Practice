class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<Integer> pq = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        pq.add(0);

        int[] r = {x, -x, y, -y};

        while(!pq.isEmpty()){
            int num = pq.poll();
            if(num == target)   return true;

            for(int i=0; i<4; i++){
                int newNum = num+r[i];
                // if(newnum == target)    
                if(newNum >= 0 && newNum <= x+y && !hs.contains(newNum)) {
                     pq.add(newNum);
                     hs.add(newNum);
                }  
                
            }

          
        }

          return false;


    }
}