import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQ {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3); // O(log N)
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()) {
            System.out.print(pq.peek() + " "); //O(1)
            pq.remove(); // O(log N)
        }
    }
}
