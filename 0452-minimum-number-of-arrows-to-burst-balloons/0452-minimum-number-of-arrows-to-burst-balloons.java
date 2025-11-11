class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));

        int res =0;

        for(int i=0; i<points.length; i++){
            int end =points[i][1];
            while(i< points.length-1 && points[i+1][0] <=end)  i++;
            res++;
        }

        return res;
    }
}