class Solution {
    public int search(int[] nums, int t) {
        int l= 0, r = nums.length-1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == t) return mid;

                // Left half is sorted
                if (nums[l] <= nums[mid]) {
                    if (t >= nums[l] && t < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                // Right half is sorted
                else {
                    if (t > nums[mid] && t <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
        }

        return -1;

    }
}