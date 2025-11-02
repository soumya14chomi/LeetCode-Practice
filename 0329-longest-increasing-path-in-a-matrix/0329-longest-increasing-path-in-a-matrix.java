class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length, m= matrix[0].length;

        Queue<int[]> qu = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // System.out.println(i+", "+j+" : "+matrix[i][j]);
                if(i>0 && matrix[i-1][j] < matrix[i][j])     continue;
                if(j>0 && matrix[i][j-1] < matrix[i][j])   continue;
                if(i<n-1 && matrix[i+1][j] < matrix[i][j]) continue;
                if(j<m-1 && matrix[i][j+1] < matrix[i][j])  continue;

                qu.add(new int[]{i, j});
            }
        }

        int res = 0;

        while(!qu.isEmpty()){
            int[] top = qu.poll();

             System.out.println(top[0]+", "+top[1]);

            res = Math.max(res, bfs(matrix, top[0], top[1], n, m));

            // System.out.
        }
        
        return res;
    }

    int bfs(int[][] matrix, int i, int j, int n, int m){

        int depth = 0;

        int[][] visited = new int[n][m];
        visited[i][j] = 1;

        int[] row = {0, 0, 1, -1}; int[] col = {1, -1, 0, 0};

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{i, j});

        while(!qu.isEmpty()){
            depth++;
            int size = qu.size();

            while(size-->0){
                int[] top = qu.poll();
                i = top[0];
                j= top[1];

                for(int idx = 0; idx<4; idx++){
                    int i1 = i + row[idx];
                    int j1 = j + col[idx];

                    if(isValid(i1, j1, n, m) && matrix[i1][j1]>matrix[i][j] && visited[i1][j1] < depth){
                        visited[i1][j1] = depth;
                        qu.add(new int[]{i1, j1});
                    }
                }
            }
        }
        return depth;

    }

    boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }

}