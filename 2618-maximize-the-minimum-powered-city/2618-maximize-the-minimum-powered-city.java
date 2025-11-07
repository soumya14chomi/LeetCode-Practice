class Solution {
    private int len, r;
    public long maxPower(int[] stations, int r, int k) {
        this.len = stations.length;
        this.r = r;

        long[] prefixSum = new long[len + 1], powers = new long[len + 1];
        for (int i = 1; i <= len; ++i) {
            prefixSum[i] += prefixSum[i - 1] + stations[i - 1];
        }
        for (int i = 1; i <= len; ++i) {
            int ub = Math.min(len, i + r), lb = Math.max(0, i - r - 1);
            powers[i] = prefixSum[ub] - prefixSum[lb];
        }

        long start = 0L, end = prefixSum[len] + k;
        while (start < end - 1) {
            long mid = start + (end - start) / 2;
            if (isReachable(mid, k, powers)) {
                start = mid;                
            } else {
                end = mid - 1;
            }
        }
        if (isReachable(end, k, powers)) return end;
        return start;
    }
    private boolean isReachable(long required, int extra, long[] powers) {

        // check the power of each city
        long[] diff = new long[len + 1];
        long powerDiff = 0L;
        for (int i = 1; i <= len; ++i) {
            powerDiff += diff[i - 1];
            long needed = required - powers[i] - powerDiff;
            if (needed > 0) {
                extra -= needed;
                if (extra < 0) return false;
                diff[i] += needed;
                if (i + 2 * r <= len) diff[i + 2 * r] -= needed;
            }
        }
        return true;
    }
}