// steps : 
// find mid
// make two part
// reverse second part
// check both part

class Node {
        int data;
        Node next; //reference variable

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

public class checkIfPalindromeLL {
    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static boolean checkParts(Node left, Node right) {
        while(left != null && right != null) {
            if(left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        Node mid = findMid(head);

        Node left = head;
        Node right = reverse(mid);

        if(checkParts(left, right)) {
            System.out.println("LL is palindrome");
        } else {
            System.out.println("LL is not palindrome");
        }
    }
}
