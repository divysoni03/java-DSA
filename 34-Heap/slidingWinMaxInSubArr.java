import java.util.PriorityQueue;

public class slidingWinMaxInSubArr {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair r2) {
            return r2.val - this.val;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        int[] res = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++) { // first window
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) { // if curr max ele's idx is out of win range then remove
                pq.remove();
            }

            pq.add(new Pair(arr[i], i)); // add curr ele
            res[i-k+1] = pq.peek().val; // add max ele in ans for curr window
        }

        for(int i: res) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
}
