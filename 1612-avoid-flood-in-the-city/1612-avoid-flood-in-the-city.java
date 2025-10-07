class Solution {
    public int[] avoidFlood(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        TreeSet<Integer> hs = new TreeSet<>();

        int n = arr.length;

        for(int i=0; i<n ;i++){
            if(arr[i] == 0){
                hs.add(i);
                arr[i] = 1;
            }
            else{
                if(hm.containsKey(arr[i])){
                    // if(hs.isEmpty())    return new int[0];
                    Integer idx = hs.ceiling(hm.get(arr[i]));

                    if(idx == null) return new int[0];
                    arr[idx] = arr[i];
                    hs.remove(idx);

                    // System.out.println(hs.toString() + idx);
                }
                    hm.put(arr[i], i);
                    arr[i] = -1;

            }
        }

        return arr;

        
    }
}