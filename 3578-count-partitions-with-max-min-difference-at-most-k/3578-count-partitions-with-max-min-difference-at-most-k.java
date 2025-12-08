
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        // Phase 1: compute far[i] = max j such that [i..j] is valid (max-min <= k)
        int[] far = new int[n];

        Deque<Integer> minDQ = new ArrayDeque<>(); // increasing values
        Deque<Integer> maxDQ = new ArrayDeque<>(); // decreasing values

        int left = 0;
        for (int right = 0; right < n; right++) {
            // push right into deques
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= nums[right]) {
                maxDQ.pollLast();
            }
            maxDQ.addLast(right);

            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] >= nums[right]) {
                minDQ.pollLast();
            }
            minDQ.addLast(right);

            // shrink from the left until window is valid
            while (!maxDQ.isEmpty() && !minDQ.isEmpty()
                    && (long) nums[maxDQ.peekFirst()] - (long) nums[minDQ.peekFirst()] > k) {
                // before moving left, assign far[left] = right - 1 (last valid end for that left)
                far[left] = right - 1;
                // pop left from deques if it sits at the front
                if (!maxDQ.isEmpty() && maxDQ.peekFirst() == left) maxDQ.pollFirst();
                if (!minDQ.isEmpty() && minDQ.peekFirst() == left) minDQ.pollFirst();
                left++;
            }
        }
        // for all remaining left positions, the window up to n-1 is valid
        while (left < n) {
            far[left] = n - 1;
            left++;
        }

        // Phase 2: DP with suffix sums
        // dp[i] = sum_{t=i..far[i]} dp[t+1]
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 2]; // pref[x] = sum(dp[x..n])
        dp[n] = 1;
        pref[n] = 1;     // dp[n]
        pref[n + 1] = 0; // sentinel

        for (int i = n - 1; i >= 0; i--) {
            // dp[i] = pref[i+1] - pref[far[i]+2]
            long val = (pref[i + 1] - pref[far[i] + 2]) % MOD;
            if (val < 0) val += MOD;
            dp[i] = val;

            // update suffix sum
            pref[i] = (dp[i] + pref[i + 1]) % MOD;
        }

        return (int) dp[0];
    }
}