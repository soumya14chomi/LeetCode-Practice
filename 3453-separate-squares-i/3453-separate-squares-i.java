
class Solution {
    public double separateSquares(int[][] squares) {
        double minY = Double.POSITIVE_INFINITY;
        double maxY = Double.NEGATIVE_INFINITY;
        double totalArea = 0.0;

        for (int i = 0; i < squares.length; i++) {
            double start = squares[i][1];
            double side = squares[i][2];
            minY = Math.min(start, minY);
            maxY = Math.max(start + side, maxY);
            totalArea += side * side;
        }

        final double EPS = 1e-5;
        double low = minY, high = maxY;

        // Binary search for y such that areaBelow(y) ≈ totalArea / 2
        while (high - low > EPS) {
            double mid = (low + high) / 2.0;
            double areaDown = findAreaBelow(squares, mid);

            if (areaDown < totalArea / 2.0) {
                // Need more area below -> move cut up
                low = mid;
            } else {
                // Too much below -> move cut down
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }

    private double findAreaBelow(int[][] squares, double yCut) {
        double area = 0.0;
        for (int i = 0; i < squares.length; i++) {
            double start = squares[i][1];
            double side = squares[i][2];

            // height of the portion below the cut within this square
            double belowHeight = Math.max(0.0, Math.min(yCut - start, side));
            area += side * belowHeight;
        }
        return area;
    }
}
