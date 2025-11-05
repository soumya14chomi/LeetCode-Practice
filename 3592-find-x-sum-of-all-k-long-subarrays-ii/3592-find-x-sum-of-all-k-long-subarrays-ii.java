import java.util.*;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        Map<Integer, Integer> count = new HashMap<>();

        TreeSet<Integer> pq = new TreeSet<>((a, b) -> {
            if (count.get(a).equals(count.get(b))) return a - b;
            return count.get(a) - count.get(b);
        });

        TreeSet<Integer> pq1 = new TreeSet<>((a, b) -> {
            if (count.get(b).equals(count.get(a))) return b - a;
            return count.get(b) - count.get(a);
        });

        long sum = 0;
        int n = nums.length;
        long[] res = new long[n - k + 1];

        for (int i = 0; i < n; i++) {

            if(!count.containsKey(nums[i])) count.put(nums[i], 0);
            

            if (pq.contains(nums[i])) {
                System.out.println("Contains: "+nums[i]);
                pq.remove(nums[i]);
                count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
                pq.add(nums[i]);
                sum += (long) nums[i];
            } else {
                if (pq.size() < x) {
                    sum += (long) nums[i];
                    count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
                    pq.add(nums[i]);
                } else {
                    if (pq1.contains(nums[i])) pq1.remove(nums[i]);
                    count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
                    pq1.add(nums[i]);

                    sum = compareAndFix(pq, pq1, sum, count);
                }
            }

            // System.out.println(pq.toString() + " "+pq1.toString()+" "+sum);


            if (i >= k - 1) {

                res[i - k + 1] = sum;

                int num = nums[i - k + 1];

                if (pq1.contains(num)) {
                    pq1.remove(num);
                    count.put(num, count.get(num) - 1);
                    if (count.get(num) > 0) pq1.add(num);
                } else {
                    pq.remove(num);
                    count.put(num, count.get(num) - 1);
                    if (count.get(num) > 0) {
                        pq.add(num);
                    } else {
                        if (pq.size() < x && !pq1.isEmpty()) {
                            int top = pq1.pollFirst();
                            sum += (long) top;
                            pq.add(top);
                        }
                    }


                if (count.get(num) == 0) count.remove(num);
                    sum -= (long) num;
                    sum = compareAndFix(pq, pq1, sum, count);
                }
            }
        }

        return res;
    }

    long compareAndFix(TreeSet<Integer> pq, TreeSet<Integer> pq1, long sum, Map<Integer, Integer> count) {
        if (!pq1.isEmpty()) {
            int top = pq.first();
            int top1 = pq1.first();

            if (count.get(top) < count.get(top1) ||
                (count.get(top).equals(count.get(top1)) && top < top1)) {

                pq.pollFirst();
                pq1.pollFirst();

                sum -= (long) top * count.get(top);
                sum += (long) top1 * count.get(top1);

                pq.add(top1);
                pq1.add(top);
            }
        }
        return sum;
    }
}