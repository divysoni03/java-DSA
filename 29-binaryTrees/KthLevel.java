public class KthLevel {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // my code
    public static void printKthLevel(Node root, int currLevel, int k) {
        if(root == null) return;

        if(currLevel == k) {
            System.out.print(root.data+", ");
            return; // so we don't go the child nodes or greater level
        }

        printKthLevel(root.left, currLevel+1, k);
        printKthLevel(root.right, currLevel+1, k);
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7

            output: 6, 5, 4, 2, 1, 3,
        */
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

        printKthLevel(root, 1, 3);
        System.out.println();
    }
}
