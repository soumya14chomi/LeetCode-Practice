class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n+1][n+1];

        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            res[x1][y1] +=1;
            res[x1][y2+1]-=1;
            res[x2+1][y1]-=1;
            res[x2+1][y2+1]+=1;
        }
        // for(int i=0; i<n+1; i++)
        //     System.out.println(Arrays.toString(res[i]));

        int[][] result = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result[i][j] = res[i][j];

                if(i>0) result[i][j]+=result[i-1][j];
                if(j>0) result[i][j]+=result[i][j-1];
                if(i>0 && j>0)  result[i][j]-=result[i-1][j-1];
            }
        }

        return result;
    }
}