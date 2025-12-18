
import java.util.*;

class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        final int MOD = 1_000_000_007;

        // prevSums[j] holds remainder->count for cell (prevRow, j)
        HashMap<Integer, Long>[] prevSums = new HashMap[m];

        // Initialize first cell
        prevSums[0] = new HashMap<>();
        prevSums[0].put(grid[0][0] % k, 1L);

        // Build the first row (i = 0)
        for (int j = 1; j < m; j++) {
            prevSums[j] = new HashMap<>();
            for (Map.Entry<Integer, Long> e : prevSums[j - 1].entrySet()) {
                int nextRem = (e.getKey() + grid[0][j]) % k;
                long val = (prevSums[j].getOrDefault(nextRem, 0L) + e.getValue()) % MOD;
                prevSums[j].put(nextRem, val);
            }
        }

        // Process remaining rows
        for (int i = 1; i < n; i++) {
            HashMap<Integer, Long>[] currSums = new HashMap[m];

            for (int j = 0; j < m; j++) {
                currSums[j] = new HashMap<>();

                // From left neighbor in current row
                if (j > 0) {
                    for (Map.Entry<Integer, Long> e : currSums[j - 1].entrySet()) {
                        int nextRem = (e.getKey() + grid[i][j]) % k;
                        long val = (currSums[j].getOrDefault(nextRem, 0L) + e.getValue()) % MOD;
                        currSums[j].put(nextRem, val);
                    }
                }

                // From top neighbor (previous row)
                for (Map.Entry<Integer, Long> e : prevSums[j].entrySet()) {
                    int nextRem = (e.getKey() + grid[i][j]) % k;
                    long val = (currSums[j].getOrDefault(nextRem, 0L) + e.getValue()) % MOD;
                    currSums[j].put(nextRem, val);
                }
            }

            prevSums = currSums; // advance to next row
        }

        return (int) (prevSums[m - 1].getOrDefault(0, 0L) % MOD);
    }
}

