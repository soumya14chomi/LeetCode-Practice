class Solution {
    public int trapRainWater(int[][] arr) {
        int res =0 , n = arr.length, m=arr[0].length;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(2).compareTo(b.get(2)));

        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            pq.offer(List.of(i, 0, arr[i][0]));
            pq.offer(List.of(i, m-1, arr[i][m-1]));

            visited[i][0] = visited[i][m-1] = true;
        }

        for(int i=1; i<m-1; i++){
            pq.offer(List.of(0, i, arr[0][i]));
            pq.offer(List.of(n-1, i, arr[n-1][i]));

            visited[0][i] = visited[n-1][i] = true;
        }

        int[] r = {0, 0, -1, 1};
        int[] l = {1, -1, 0, 0};
        while(!pq.isEmpty()){

            List<Integer> curr = pq.poll();

            int i = curr.get(0);
            int j= curr.get(1);
            int height = curr.get(2);

            for(int dir=0; dir<4; dir++){
                int i1 = i+r[dir], j1 = j+l[dir];
                if(isValid(i1, j1, n, m) && !visited[i1][j1]){

                    if(arr[i1][j1] <= height){

                        // System.out.println("here");
                        res+= height - arr[i1][j1] ;
                    
                    }
                    pq.offer(List.of(i1, j1, Math.max(height, arr[i1][j1])));
                     visited[i1][j1] =true;
                }

               
            }

        }

        return res;
    }

    boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}