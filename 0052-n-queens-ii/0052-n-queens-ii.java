class Solution {
    int count =0;
    public int totalNQueens(int n) {
        helper(0, n, new HashSet<>(), new int[n], new int[n]);
        return count;
    }

    void helper(int i, int n, Set<Integer> col, int[] rows, int[] cols){
        if(i == n)    {
            count++;
            return;
        }

        // for(int i=row; i<n; i++){
            for(int j=0; j<n; j++){
                if(!col.contains(j)){
                    boolean isValid = true;
                    for(int k=1; k<=i; k++){
                        if(rows[i-k] == j-k || rows[i-k] == j+k)    isValid = false;
                    }
                    if(isValid){
                        System.out.println(i+" "+j);
                        col.add(j);
                        rows[i] = j;
                        cols[j] = i;
                        helper(i+1, n, col, rows, cols);
                        col.remove(j);
                    }
                    

                    
                }
            // }
            // if(col.size()!=i+1)  return;    
        }

    }
}