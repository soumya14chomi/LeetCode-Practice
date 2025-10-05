class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
       List<List<Integer>> res = new ArrayList<>();

       int n=arr.length, m= arr[0].length;

       Queue<List<Integer>> qu = new LinkedList<>();
       boolean[][] visited = new boolean[n][m];
       for(int i=0; i<m; i++){
        qu.add(List.of(0, i));
        visited[0][i] = true;
       }

       for(int i=1; i<n; i++){
        qu.add(List.of(i, 0));
        visited[i][0] = true;
       }

       int[] row = {0, 1, 0, -1};
       int[] col = {1, 0, -1, 0};

       while(!qu.isEmpty()){
            List<Integer> lst = qu.poll();
            int i = lst.get(0);
            int j = lst.get(1);

            for(int k=0; k<4; k++){
                int i1 = i+row[k];
                int j1 = j+col[k];
                if(isValid(i1, j1, n, m) 
                        && !visited[i1][j1]
                        && arr[i1][j1] >= arr[i][j]){
                            visited[i1][j1] = true;
                            qu.add(List.of(i1, j1));
                        }
            }
       } 

       qu.clear();
        for(int i=0; i<m; i++){
            qu.add(List.of(n-1, i, arr[n-1][i]));
            arr[n-1][i] = -1;
            if(visited[n-1][i]) res.add(List.of(n-1, i));
       }

       for(int i=0; i<n-1; i++){
            qu.add(List.of(i, m-1, arr[i][m-1]));
            arr[i][m-1] = -1;
            if(visited[i][m-1]) res.add(List.of(i, m-1));
       }

       while(!qu.isEmpty()){
        // System.out.println(qu.peek().toString());
         List<Integer> lst = qu.poll();
            int i = lst.get(0);
            int j = lst.get(1);
            int h = lst.get(2);

            for(int k=0; k<4; k++){
                int i1 = i+row[k];
                int j1 = j+col[k];
                if(isValid(i1, j1, n, m) 
                        && arr[i1][j1] >= h){
                            
                            qu.add(List.of(i1, j1, arr[i1][j1]));
                            arr[i1][j1] = -1;
                            if(visited[i1][j1]) 
                                res.add(List.of(i1, j1));

                        }
            }
       }
            
        return res;
    }

    boolean isValid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
}