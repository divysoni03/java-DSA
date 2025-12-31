import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            int top = -1;

            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) break;
                    q1.add(top);
                }
            }

            return top;
        }

        public int peek() {
            int top = -1;

            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.peek();
                    q2.add(q1.remove());
                }
            } else {
                while(!q2.isEmpty()) {
                    top = q2.peek();
                    q1.add(q2.remove());
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();
    }
}
