class Solution {
    public int[] findOrder(int n, int[][] arr) {
        List<Integer>[] graph = new ArrayList[n];

        int[] degree = new int[n];
        int[] bfs = new int[n]; int count=0;

        for(int i=0;i<n;i++)    graph[i] = new ArrayList<>();

        for(int i=0; i<arr.length;i++){
            graph[arr[i][1]].add(arr[i][0]);
            degree[arr[i][0]]++;
        }

        for(int i=0;i<n;i++)    {
            if(degree[i] == 0)  bfs[count++] = i;
        }

        for(int i=0; i<count;i++){
            for(int v: graph[bfs[i]]){
                degree[v]--;
                if(degree[v] == 0)  bfs[count++] = v;
            }
        }

        return count == n ? bfs : new int[0];
    }
}