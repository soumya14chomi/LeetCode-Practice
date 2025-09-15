class Solution {

    void traverse(char[][] grid, Queue<Pair<Integer, Integer>> qu, int[][] visited, int n, int m){
        while(!qu.isEmpty()){
            Pair pair  = qu.poll();
            int i= (Integer)pair.getKey();
            int j= (Integer)pair.getValue();

            if(visited[i][j] == 1)  continue;
            if(i>0 && grid[i-1][j] == '1' )  qu.add(new Pair(i-1, j));
            if(j>0 && grid[i][j-1] == '1')    qu.add(new Pair(i, j-1));
            if(i<n-1 && grid[i+1][j] == '1')    qu.add(new Pair(i+1, j));
            if(j<m-1 && grid[i][j+1] =='1')     qu.add(new Pair(i, j+1));
            visited[i][j] = 1;
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m=grid[0].length;
        int[][] visited = new int[n][m];
        int count=0;

        Queue<Pair<Integer, Integer>> qu = new LinkedList<>();

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && visited[i][j]==0){
                    qu.add(new Pair(i, j));
                    // visited[i][j] =1;
                    traverse(grid, qu, visited, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}