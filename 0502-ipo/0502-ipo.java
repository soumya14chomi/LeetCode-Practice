class Solution {
    class Pair{
        Integer left;
        Integer right;
        Pair(int l, int r){
            left = l;
            right =r;
        }

        Integer getLeft(){
            return left;
        }
        Integer getRight(){
            return right;
        }

        @Override
        public String toString(){
            return left+" "+right;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        int n = p.length;

        List<Pair> pairs = new ArrayList<>();

        for(int i=0; i<n; i++){

            pairs.add(new Pair(c[i], p[i]));
        }

        Collections.sort(pairs, (a, b) -> {
            if((a.getLeft()).equals(b.getLeft()))    return b.getRight().compareTo(a.getRight());

            return a.getLeft().compareTo(b.getLeft());
            
        });

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (a, b) -> b.getRight().compareTo(a.getRight()));
        int idx =0, i =0;
        // System.out.println(pairs.toString());
        while(idx < k){
            while(i<n && w>=pairs.get(i).getLeft()){
                pq.add(pairs.get(i++));
            }
            //  System.out.println(pq.toString());

            if(!pq.isEmpty()){
                Pair removed = pq.poll();
                w+=removed.getRight();
                idx++;
            }
            else    break;

            // System.out.println("profit:" + w);
           

        }
        return w;
        
    }
}