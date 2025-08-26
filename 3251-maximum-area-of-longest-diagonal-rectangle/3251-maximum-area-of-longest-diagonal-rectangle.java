class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {
        int maxArea = 0;
        double maxDia =0;

        for(int i=0; i<arr.length; i++){
            double dia = Math.sqrt(arr[i][0]*arr[i][0] + arr[i][1]*arr[i][1]);
            if(dia > maxDia)   {
                maxDia = dia;
                maxArea = arr[i][0] * arr[i][1];
            }
            else if(dia == maxDia){
                maxArea = Math.max(maxArea, arr[i][0]*arr[i][1]);
            }
        }
        return maxArea;
    }
}