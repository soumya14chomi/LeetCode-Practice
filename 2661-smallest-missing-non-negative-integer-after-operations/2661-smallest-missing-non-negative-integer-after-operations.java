class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n;i++){
            int num = (nums[i]%value+value)%value;
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int min = 0, position = 0;

        for(int i=0; i< value; i++){
            if(!hm.containsKey(i))  return i;
            if(hm.get(min) > hm.get(i)) {
                min = i;
            }
        }

        // System.out.println(min);
        return value*hm.get(min) + min;

        
    }
}