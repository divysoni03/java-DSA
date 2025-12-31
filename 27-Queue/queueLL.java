public class queueLL {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty() {
        return head==null && tail==null;
    }

    public static void add(int data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static int remove() {
        if(head == null) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if(head == tail) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        return val;
    }

    public static int peek() {
        if(head == null) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return head.data;
    }

    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);

        while(!isEmpty()) {
            System.out.print(peek() + " ");
            remove();
        }
        System.out.println();
    }
}
