class Solution {

    int n;
    int[] arr;

    public Solution(int[] nums) {
        this.n = nums.length;
        this.arr = nums;
    }
    
    public int[] reset() {
        return arr;
    }
    
    public int[] shuffle() {
        int[] temp = new int[n];
        Set<Integer> hs = new HashSet<>();

        for(int i=0; i<n; i++){
            int next = i;
            do{
               next = (int)(Math.random() * n);
            }   
            
            while(hs.contains(next));

            temp[i] = arr[next];
            hs.add(next);


        }

        return temp;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */