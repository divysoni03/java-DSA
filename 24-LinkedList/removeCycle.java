class Node {
    int data;
    Node next; //reference variable

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class removeCycle {
    public static boolean detectNRemoveCycle(Node head) {
        // detecting the cycle
        Node slow = head, fast = head;
        boolean isCycle = false;
        while(fast!=null && fast.next!=null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        // removing it
        Node prev = null;
        if(isCycle) {
            slow = head;
            while(slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            prev.next = null;
        }

        return isCycle;
    }

    public static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        Node connNode = new Node(2);
        head.next.next = connNode;
        head.next.next.next = new Node(3);
        head.next.next.next.next = connNode;

        // printLL(head);
        
        if(detectNRemoveCycle(head)) {
            System.out.println("cycle exists");
            printLL(head);
        } else {
            System.out.println("doesn't exists");
        }
    }
}
