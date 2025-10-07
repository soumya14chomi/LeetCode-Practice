class Solution {
    public int[][] reconstructQueue(int[][] arr) {

       Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0]; // height descending
            return a[1] - b[1]; 
       });

        ArrayList<int[]> lst = new ArrayList<>();

        for(int i=0; i< arr.length; i++)    lst.add(new int[0]);

        for(int i=0; i<arr.length; i++){
            lst.add(arr[i][1], new int[]{arr[i][0], arr[i][1]});
        }

        for(int i=0; i<arr.length; i++){

            arr[i] = lst.get(i);
        }

        return arr;



    }
}