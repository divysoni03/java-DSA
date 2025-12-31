public class queueArray {
    static int SIZE = 10;

    static class Queue {
        int arr[] = new int[SIZE];

        int front=0;
        int rear=-1;

        public boolean isEmpty() {
            if(rear == -1) return true;
            return false;
        }

        // add
        public void add(int data) {
            if(rear+1 == arr.length) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }

            int val = arr[front];
            for(int i=0;i<rear;i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return val;
        }
        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
