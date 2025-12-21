// steps 
// 1. find mid
// 2. divide the ll in two parts
// 3. sort and merge them

class Node {
    int data;
    Node next; //reference variable

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class mergeSortLL {
    public static Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node mergeLL(Node left, Node right) {
        Node result = new Node(-1);
        Node temp = result;
        
        while(left!=null || right!=null) {
            if(left == null) { // if left is empty add whole right ll
                temp.next = right;
                break;
            }
            if(right == null) { // if right is empty add whole left ll
                temp.next = left;
                break; 
            }

            if(left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        return result.next;
    }

    public static Node mergeSort(Node head) {
        // base case (for : [] & [one ele])
        if(head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = findMid(head);

        // make two parts
        // Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        // call recursively 
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // merging them
        return mergeLL(newLeft, newRight);
    }

    public static void printLL(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        printLL(head);
        head = mergeSort(head);
        printLL(head);
    }
}
