class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] steps = new int[n*n+1];

        Arrays.fill(steps, -1);
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        steps[1] =0;

        // int rows=n-1, col =0;

        while(!qu.isEmpty()){
            int x = qu.poll();
            for(int i=1; i<=6 && i+x<=n*n; i++){
                int t = x+i;
                int row = (t-1)/n;
                int col = (t-1)%n;

                int v = board[n-row-1][row%2 == 1 ? n-1-col : col];
                int y = v>0 ? v : t;

                if(y == n*n)    return  steps[x]+1;

                if(steps[y] == -1)  {
                    steps[y] = steps[x]+1;
                    qu.add(y);
                }
            }
        }
        return -1;
        
    
    }
}