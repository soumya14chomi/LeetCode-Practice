class Solution {
    public int[] processQueries(int n, int[][] edges, int[][] qu) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> lst = new ArrayList<>();
        
        for(int i=0; i<n; i++)  lst.add(new ArrayList<>());

        for(int i=0; i<edges.length; i++){
            lst.get(edges[i][0]-1).add(edges[i][1]-1);
            lst.get(edges[i][1]-1).add(edges[i][0]-1);
        }

        HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            if(!visited[i]){
                // System.out.println(" before Traversing: "+hm.toString());
                bfs(i, hm, new TreeSet<>(), lst, visited);
                // System.out.println(" After Traversing: "+hm.toString());
            }
        }

        List<Integer> res  = new ArrayList<>();

        for(int i=0; i<qu.length; i++){
            int x = qu[i][1]-1;

            if(qu[i][0] == 1){
                if(hm.get(x).contains(x))    res.add(x+1);
                else if(hm.get(x).size() == 0 ) res.add(-1);
                else    res.add(hm.get(x).first()+1);
            }
            else{
                hm.get(x).remove(x);
            }
        }

        int[] dummy = new int[res.size()];

        for(int i=0; i<res.size(); i++) dummy[i] = res.get(i);

        return dummy;
    }

    void bfs(int i, HashMap<Integer, TreeSet<Integer>> hm, TreeSet<Integer> ts, List<List<Integer>> lst, boolean[] visited){

        Queue<Integer> qu = new LinkedList<>();

        qu.add(i);
        visited[i] = true;
        ts.add(i);
        hm.put(i, ts);
        
        while(!qu.isEmpty()){
            int idx = qu.poll();
            for(int v : lst.get(idx)){
                if(!visited[v]){
                    qu.add(v);
                    visited[v] = true;
                    ts.add(v);
                    hm.put(v, ts);
                }
            }
        }
    }
}