import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                gain(b.getKey(), b.getValue()),
                gain(a.getKey(), a.getValue())
            )
        );

        for (int[] cls : classes) {
            pq.add(new Pair<>(cls[0], cls[1]));
        }

        while (extraStudents-- > 0) {
            Pair<Integer, Integer> p = pq.poll();
            int pass = p.getKey(), total = p.getValue();
            pq.add(new Pair<>(pass + 1, total + 1));
        }

        double sum = 0.0;
        for (Pair<Integer, Integer> p : pq) {
            sum += (double) p.getKey() / p.getValue();
        }

        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }
}
