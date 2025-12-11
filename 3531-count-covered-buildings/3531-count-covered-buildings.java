class Solution {
    public int countCoveredBuildings(int n, int[][] arr) {
        HashMap<Integer, TreeSet<Integer>> xAxis = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> yAxis = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!xAxis.containsKey(arr[i][0]))  xAxis.put(arr[i][0], new TreeSet<>());

            if(!yAxis.containsKey(arr[i][1]))  yAxis.put(arr[i][1], new TreeSet<>());

            xAxis.get(arr[i][0]).add(arr[i][1]);
            yAxis.get(arr[i][1]).add(arr[i][0]);
        }

        int res = 0;

        for(int i=0; i<arr.length; i++){
            if(xAxis.containsKey(arr[i][0]) && yAxis.containsKey(arr[i][1])){
                if(xAxis.get(arr[i][0]).floor(arr[i][1] - 1) == null || 
                    xAxis.get(arr[i][0]).ceiling(arr[i][1] + 1) == null ||
                    yAxis.get(arr[i][1]).ceiling(arr[i][0] + 1) == null||
                    yAxis.get(arr[i][1]).floor(arr[i][0] - 1) == null)
                        continue;
                else res++;
            }
        }

        return res;


    }
}