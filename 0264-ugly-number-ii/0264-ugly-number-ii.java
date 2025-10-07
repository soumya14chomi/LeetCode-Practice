class Solution {
    public int nthUglyNumber(int n) {
        int count =0;

        PriorityQueue<Long> pq  = new PriorityQueue<>();
        Set<Long> hs = new HashSet<>();

        pq.add((long) 1);

        for(int i=1; i<n; i++){
            long num = pq.poll();

            if(!hs.contains(num*2)) pq.add(num*2);
            if(!hs.contains(num*3)) pq.add(num*3);
            if(!hs.contains(num*5)) pq.add(num*5);

            hs.add(num*2);
            hs.add(num*3);
            hs.add(num*5);
        }

        return (pq.poll()).intValue();
    }
}