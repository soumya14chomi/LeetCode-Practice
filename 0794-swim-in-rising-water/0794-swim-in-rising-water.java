class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int[][] minTime = new int[n][m];

                PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> minTime[a.get(0)][a.get(1)] - (minTime[b.get(0)][b.get(1)]));

        for(int i=0; i<n;i++)   Arrays.fill(minTime[i] , Integer.MAX_VALUE);

        pq.add(List.of(0, 0));
        minTime[0][0] = grid[0][0];

        int[] rdir = {0, 0, 1, -1}, ldir = {1, -1, 0, 0};

        while(!pq.isEmpty()){
            List<Integer> top = pq.poll();
            if(top.get(0) == n-1 && top.get(1) == m-1)  break;

            int i = top.get(0);
            int j = top.get(1);
            for(int k=0; k<4; k++){
                int i1= i+rdir[k], j1 = j+ldir[k];
                if(isValid(i1, j1, n, m)){
                    if(minTime[i1][j1] > Math.max(minTime[i][j], grid[i1][j1])){
                        minTime[i1][j1] = Math.max(minTime[i][j], grid[i1][j1]);
                        pq.add(List.of(i1, j1));
                    }
                }
            }

        }

         return minTime[n-1][m-1];



    }

        boolean isValid(int i, int j, int n, int m){
            return i>=0 && j>=0 && i<n && j<m;
    }
}