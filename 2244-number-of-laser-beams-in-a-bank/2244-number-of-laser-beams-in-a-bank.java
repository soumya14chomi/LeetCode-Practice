class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0, prev = 0;

        int n = bank.length;

        for(int i=0; i<n; i++){
            int m = bank[i].length();
            int count =0;

            for(int j=0; j<m; j++){
                
                if(bank[i].charAt(j) == '1'){
                    count++;
                }
            }

            if(count > 0){
                sum+=(prev*count);
                prev = count;

            }

        }

        return sum;

    }
}