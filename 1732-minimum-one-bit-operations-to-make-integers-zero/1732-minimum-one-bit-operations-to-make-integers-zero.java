import java.util.*;

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minimumOneBitOperations(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int k = 31 - Integer.numberOfLeadingZeros(n); // highest set bit position
        int mask = 1 << k;

        int result = (1 << (k + 1)) - 1 - dfs(n ^ mask);
        memo.put(n, result);
        return result;
    }
}