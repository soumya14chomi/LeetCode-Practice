
class Solution {
    public int numberOfWays(String corridor) {
        int res = 1, count = 0, plantCount = 0, n = corridor.length();
        final int MOD = 1_000_000_007;

        // Quick seat count check
        int totalSeats = 0;
        for (int j = 0; j < n; j++) {
            if (corridor.charAt(j) == 'S') totalSeats++;
        }
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') count++;

            if (count == 2) {
                // Count plants until the next seat
                int j = i + 1;
                plantCount = 0; // reset per block
                while (j < n && corridor.charAt(j) == 'P') {
                    plantCount++;
                    j++;
                }
                // If next char is a seat, multiply by (plantCount + 1)
                if (j < n && corridor.charAt(j) == 'S') {
                    res = (int) ((res * (long) (plantCount + 1)) % MOD);
                }
                // Set up for the next block: we've consumed one seat at j
                count = 1;       // we've already encountered the seat at j
                i = j;           // move i to j
            }
        }
        return res;
    }
}
