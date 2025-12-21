public class LinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {
        int data;
        Node next; //reference variable

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    public static void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static void addAtIndex(int data, int index) {
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(i< index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return -1;
        }
        if(head.next == null) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }

        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public static int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return -1;
        }
        if(size == 1) {
            int data = head.data;
            head = tail = null;
            size--;
            return data;
        }
        
        Node prev = head;
        for(int i=0;i<size-2;i++) prev = prev.next;
        int data = prev.next.data;
        tail = prev;
        size--;
        return data;
    }
    
    public static int searchLL(Node Head, int target) { // recursive
        if(Head == null) return -1;

        if(Head.data == target) return 0;
        int index = searchLL(Head.next, target);
        if(index == -1) return -1;

        return index + 1;
    }

    public static void reverseLL() {
        Node prev=null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void removeAtIndex(int i) {
        if(i == size) {
            head = head.next;
            size--;
            return;
        }

        Node prev = head;
        while(i<size-i+1) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static void printLL() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(2);
        addFirst(3);
        printLL();
    }
}