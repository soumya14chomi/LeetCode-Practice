class Solution {
    public int countTrapezoids(int[][] arr) {

        final int MOD = 1000000007;

        int n = arr.length;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(arr[i][1], hm.getOrDefault(arr[i][1], 0)+1);
        }

        long totalLines = 0;
        for(int point : hm.values()){
            long lines = ((long)(point) * (point-1))/2;
            totalLines+=lines;
        }
        long res = 0;
        for(int point : hm.values()){
            long lines = ((long)(point) * (point-1))/2;
            res += ((totalLines - lines) * lines);
        }

        return (int)((res/2)%MOD);
    }
}