import java.util.Deque;
import java.util.LinkedList;

public class dequeIntro {
    static class Stack{
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() { return dq.isEmpty(); }

        public void push(int data) { dq.addLast(data); }

        public int pop() { return dq.removeLast(); }

        public int peek() { return dq.getLast(); }
    }

    static class Queue{
        Deque<Integer> dq = new LinkedList<>();

        public boolean isEmpty() { return dq.isEmpty(); }

        public void add(int data) { dq.addLast(data); }

        public int remove() { return dq.removeFirst(); } 

        public int peek() { return dq.getFirst(); }
    }

    public static void main(String[] args) {
        // Deque<Integer> dq = new LinkedList<>();

        // dq.addFirst(1);
        // dq.addFirst(2);
        // dq.addLast(3);

        // System.out.println(dq);

        // dq.removeFirst();
        // System.out.println(dq);
        // dq.removeLast();
        // System.out.println(dq);


        // System.out.println("\nfirst ele:" + dq.getFirst());
        // System.out.println("last ele:" + dq.getLast());

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
    }
}
