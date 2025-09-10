class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count =0;

        int i=0;

        while(i<points.length){
            int[] prev = points[i];
            count++;

            while(i+1<points.length && prev[1] >= points[i+1][0]){
                System.out.println("in here: "+ prev[1]+" "+points[i+1][0]);
                i++;
                prev[0] = Math.max(prev[0], points[i][0]);
                prev[1] = Math.min(prev[1], points[i][1]);
            }
            i++;
        }

        return count;
    }
}