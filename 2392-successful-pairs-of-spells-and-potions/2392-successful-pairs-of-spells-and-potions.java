class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0, right = m - 1;
            int idx = m;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) spell * potions[mid] >= success) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = m - idx;
        }

        return result;
    }
}
