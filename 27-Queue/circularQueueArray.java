public class circularQueueArray{
    static class Queue{
        int[] arr;
        int front=-1, rear=-1;
        int size;

        public Queue(int size) {
            this.size = size;
            this.arr = new int[size];
        }

        public boolean isEmpty() {
            return rear==-1 && front==-1;
        }

        public boolean isFull() {
            return (rear+1) % size == front;
        }

        //add
        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if(front == -1) front = 0;
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        //remove
        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            if(rear == front) {
                int val = arr[front];
                front = rear = -1;
                return val;
            }

            int val = arr[front];
            front = (front+1) % size;
            return val;
        }

        //peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);

        q.add(1);
        q.add(2);
        q.add(3);

        q.add(4);
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}