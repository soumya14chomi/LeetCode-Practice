class Solution {
    
    public boolean canFinish(int n, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList<>();

        for(int i=0;i<n;i++)    graph.add(new ArrayList<>());

        for(int i=0; i<arr.length; i++){
        
            graph.get(arr[i][1]).add(arr[i][0]);
            degree[arr[i][0]]++;
        }

        for(int i=0;i<n;i++){
            if(degree[i] ==0)   bfs.add(i);
        }
        for(int i=0;i<bfs.size();i++){
            for(int v : graph.get(bfs.get(i))){
                degree[v]--;
                if(degree[v] ==0)  bfs.add(v);
            }
        }

        return bfs.size() == n;
    }

    
}