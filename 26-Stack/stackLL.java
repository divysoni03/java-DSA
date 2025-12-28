class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stackLL {
    static public class Stack {
        Node head = null;
        int size = 0;

        public boolean isEmpty() {
            if(head == null) return true;
            return false;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            size++;
            if(head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if(head == null) {
                System.out.println("stack is empty!");
                return Integer.MIN_VALUE;
            }

            if(head.next == null) {
                int val = head.data;
                head = null;
                size--;
                return val;
            }

            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int peek() {
            if(head == null) {
                System.out.println("stack is empty!");
                return Integer.MIN_VALUE;
            }

            return head.data;
        }
    }

    public static void printStack(Stack ms) {
        while(!ms.isEmpty()) {
            System.out.println("|  " + ms.peek() + "  |");
            ms.pop();
        }
        System.out.println("-------");
    }

    public static void main(String[] args) {
        Stack ms = new Stack();

        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);

        printStack(ms);
    }
}