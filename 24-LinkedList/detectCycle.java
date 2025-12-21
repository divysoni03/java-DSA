class Node {
    int data;
    Node next; //reference variable

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class detectCycle {
    public static boolean find(Node head) {
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        Node connNode = new Node(2);
        head.next.next = connNode;
        head.next.next.next = new Node(3);
        head.next.next.next.next = connNode;

        if(find(head)) {
            System.out.println("cycle exists");
        } else {
            System.out.println("doesn't exists");
        }
    }
}
