class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> hm = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<n;i++){
            int num = (nums[i]%value+value)%value;
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        System.out.println(hm.toString());

        for(int i=0; i<=n; i++){
            if(hm.isEmpty() || !hm.containsKey(i%value))    return i;
            hm.put(i%value, hm.get(i%value)-1);

            if(hm.get(i%value) == 0)    hm.remove(i%value);
        }

        return n+1;
        
    }
}