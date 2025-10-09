class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> lst = new ArrayList<>();
        List<Integer> res = new ArrayList<>(Collections.nCopies(n, 0)); // Pre-fill with zeros

        for (int i = n - 1; i >= 0; i--) {
            int idx = binarySearch(lst, nums[i]);
            res.set(i, idx); // idx is the count of smaller elements
            lst.add(idx, nums[i]); // insert in sorted order
        }

        return res;
    }

    int binarySearch(List<Integer> lst, int num) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (lst.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
