class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(a)-hm.get(b));

        for(int i : hm.keySet()){
            pq.add(i);

            if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k;i++){
            res[i] = pq.poll();
        }

        return res;

    }
}