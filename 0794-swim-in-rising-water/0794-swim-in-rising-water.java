class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length, m = grid[0].length;
         boolean[][] visited = new boolean[n][m];

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));

        pq.add(List.of(0, 0, grid[0][0]));
        // minTime[0][0] = grid[0][0];
        visited[0][0] = true;

        int[] rdir = {0, 0, 1, -1}, ldir = {1, -1, 0, 0};

        while(!pq.isEmpty()){
            List<Integer> top = pq.poll();
            if(top.get(0) == n-1 && top.get(1) == m-1)  return top.get(2);

            int i = top.get(0);
            int j = top.get(1);
            int h = top.get(2);
            for(int k=0; k<4; k++){
                int i1= i+rdir[k], j1 = j+ldir[k];
                if(isValid(i1, j1, n, m) && !visited[i1][j1]){
                    pq.add(List.of(i1, j1, Math.max(grid[i1][j1], h)));
                    visited[i1][j1] = true;
                }
            }

        }

         return -1;



    }

        boolean isValid(int i, int j, int n, int m){
            return i>=0 && j>=0 && i<n && j<m;
    }
}