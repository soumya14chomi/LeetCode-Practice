class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );

        // Initialize the heap with pairs (i, 0)
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0], j = pair[1];
            res.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
            k--;
        }

        return res;
    }
}
