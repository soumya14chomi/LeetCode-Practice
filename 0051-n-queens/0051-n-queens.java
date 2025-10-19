class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        helper(new int[n], 0, n, res);

        return res;
    }

    void helper(int[] queens, int row, int n,  List<List<String>> res){

        if(row == n){
            res.add(formResult(queens));
            return;
            // return true;
        }

        for(int i=0; i<n; i++){

            queens[row] = i;

            if(valid(queens, n, i, row)){
                helper(queens, row+1, n, res);
                // return true;
            }   

            queens[row] = -1;

        }

        // return false;

    }

    boolean valid(int[] queens, int n, int idx, int row){

        for(int i=0; i<row; i++){
            if(queens[i] == idx)    return false;
        }

        int count =1;

        for(int i=row-1; i>=0; i--){
            if(queens[i] == idx-count || queens[i] == idx+count)  return false;
            count++;
        }

        return true;


    }

    List<String> formResult(int[] queens){

        int n = queens.length;

        List<String> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            char[] ch = new char[n];
            Arrays.fill(ch, '.');

            ch[queens[i]] = 'Q';

            res.add(new String(ch));

        }

        return res;

    }
}