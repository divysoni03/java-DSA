import java.util.PriorityQueue;

public class nearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int idx;
        int distSq;

        public Point(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.distSq = x*x + y*y;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }
    public static void main(String[] args) {
        int[][] pts = {{3, 3}, {5, -1}, {-2, 4}};
        int k=2;

        // storing all the cars in the queue (which will be sorted by the distSq)
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++) {
            pq.add(new Point(pts[i][0], pts[i][1], i));
        }

        // removing only k nearest cars from the origin
        for(int i=0;i<k;i++) {
            System.out.println("Car" + pq.remove().idx);
        }
    }
}
