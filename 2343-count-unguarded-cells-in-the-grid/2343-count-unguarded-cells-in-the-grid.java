class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int[][] grid = new int[n][m];

        for(int i=0;i<guards.length; i++)   grid[guards[i][0]][guards[i][1]] = 1;

        for(int i=0; i<walls.length; i++)   grid[walls[i][0]][walls[i][1]] = 2;

        // for(int i=0; i<n ;i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        // System.out.println();

        int total = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(grid[i][j] == 1) bfs(grid, i, j, n, m);

            }
        }

        // for(int i=0; i<n ;i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                 
                if(grid[i][j] == 0) {
                    total++;
                    // System.out.println(i+" : "+j);
                }
            }
        }

        return total;
    }

    void bfs(int[][] grid, int i, int j, int n, int m){
        int i1 = i-1, j1 = j-1;

        while(i1>=0 && grid[i1][j]!=2 && grid[i1][j]!=1) grid[i1--][j] = 3;
        while(j1>=0 && grid[i][j1]!=2 && grid[i][j1]!=1)  grid[i][j1--] = 3;

        i1 = i+1; j1=j+1;

        while(i1<n && grid[i1][j]!=2 && grid[i1][j]!=1) grid[i1++][j] = 3;
        while(j1<m && grid[i][j1]!=2 && grid[i][j1]!=1)   grid[i][j1++] = 3;
    }


}