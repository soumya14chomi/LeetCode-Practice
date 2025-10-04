class Solution {
    public List<List<Integer>> getSkyline(int[][] a) {
        int n= a.length;
        int[][] arr = new int[2*n][];

        int idx = 0;

        for(int i=0;i<n;i++){
            arr[idx++] =  new int[]{a[i][0], a[i][2]};
            arr[idx++] = new int[]{a[i][1], -a[i][2]};
        }

        Arrays.sort(arr, (b, c) -> {
            if(b[0] == c[0])    return c[1] - b[1];
            return b[0] - c[0];
        });
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((b, c) -> c - b);
        pq.add(0);
        int currHeight = 0;

        for(int i=0; i<2*n; i++){
            int x = arr[i][0];
            int h = arr[i][1];
            if(h>0){
                pq.offer(h);
            }
            else{
                h = h*(-1);
                pq.remove(h);
            }
            if(currHeight != pq.peek()){
                res.add(List.of(x, pq.peek()));
                currHeight = pq.peek();
            }
        }
        return res;
    }
}