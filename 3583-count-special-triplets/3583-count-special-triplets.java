
import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long res = 0;
        final int MOD = 1_000_000_007;

        Map<Integer, Integer> before = new HashMap<>();
        Map<Integer, Integer> after = new HashMap<>();

        // Initialize 'after' with all elements except first
        for (int i = 2; i < n; i++) {
            after.put(nums[i], after.getOrDefault(nums[i], 0) + 1);
        }

        before.put(nums[0], 1);

        for (int i = 1; i < n - 1; i++) {
            long target = (long) nums[i] * 2;

            if (before.containsKey((int) target) && after.containsKey((int) target)) {
                long count = (long) before.get((int) target) * after.get((int) target);
                res = (res + count) % MOD;
            }

            // Update maps
            before.put(nums[i], before.getOrDefault(nums[i], 0) + 1);

            int nextVal = nums[i + 1];
            after.put(nextVal, after.get(nextVal) - 1);
            if (after.get(nextVal) == 0) {
                after.remove(nextVal);
            }
        }

        return (int) res;
    }
}
