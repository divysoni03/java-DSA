class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
} 

public class doublyLL {
    static Node head=null, tail=null;
    static int size = 0; 

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static int removeFirst() {
        if(head == null) {
            System.out.println("List is empty!");
            return -1;
        }
        size--;
        if(head.next == null) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null; // removing the prev connection so node can be disconnected completely
        return val;
    }

    public static int removeLast() {
        if(head == null) {
            System.out.println("List is empty!");
            return -1;
        }
        size--;
        if(head.next == null) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    public static void reverseLL() {
        Node prev = null, curr=head, next;
        while(curr!=null) {
            // updating the links
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            // incrementing the positions
            prev = curr;
            curr = next;
        }
        head = prev; // updating the starting point
    }
    
    public static void printLL() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
    public static void main(String[] args) {
        addFirst(2);
        addFirst(1);
        addLast(3);
        addLast(4);
        printLL();

        reverseLL();

        printLL();
    }
}
