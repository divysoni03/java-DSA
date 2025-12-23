/**
 * steps :
 * 1.find mid
 * 2. divide them into two parts
 * 3. reverse  the 2nd part
 * 4. alternate merging (without extra space)
 */

class Node {
    int data;
    Node next; //reference variable

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class zigZagLL {
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node head) {
        Node prev=null, curr=head, next=null;
        while(curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void mergeLL(Node LH, Node RH) {
        Node leftH=LH, rightH=RH;
        Node nextR=null, nextL=null;

        while(leftH!=null && rightH!=null) {
            nextL = leftH.next;
            leftH.next = rightH;
            nextR = rightH.next;
            rightH.next = nextL;

            leftH = nextL;
            rightH = nextR;
        }
    }

    public static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = new Node(6);
        
        printLL(head);

        Node mid = findMid(head);
        Node RH = reverse(mid.next);
        mid.next = null;

        mergeLL(head, RH);
        printLL(head);
    }
}
