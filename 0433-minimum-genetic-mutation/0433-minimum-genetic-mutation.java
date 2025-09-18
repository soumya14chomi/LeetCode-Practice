class Solution {
    public int minMutation(String start, String end, String[] bank) {

        if(start.equals(end))   return 0;

        int n = bank.length;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            if(diff(start, bank[i]) == 1){
                graph[i+1].add(0);
                graph[0].add(i+1);
            }
        } 

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n;j++){
                if(diff(bank[i], bank[j]) == 1) {
                    // System.out.println(i+" "+j);
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }

        // for(int i=0; i<n+2;i++){
        //     System.out.println(graph[i].toString());
        // }

        return bfs(graph, 0, n+1, end, bank);

        // return depth == Integer.MAX_VALUE? -1 : depth;

    }

    int diff(String s, String end){
        int diff = 0;
        // System.out.println(s+" "+end);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != end.charAt(i))    diff++;
        }

        return diff;

    }

    int bfs(List<Integer>[] graph,int start, int end, String str, String[] bank){
         Queue<Integer> qu=new LinkedList<>();
         int depth = 0;
         int[] visited = new int[end+1];
         qu.add(start);
        

        while(!qu.isEmpty()){
             int size = qu.size();
            for(int i=0; i<size;i++){
                int idx = qu.poll();
                if(idx>0 && bank[idx-1].equals(str))  return depth;
                // visited[idx] = 1;
                for(int v : graph[idx]){
                    if(visited[v] == 0)  qu.add(v);
                    visited[v] = 1;
                }
            
            }
           
            depth++;
        }
        return -1;
         
    }
}