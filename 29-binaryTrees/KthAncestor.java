public class KthAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int ancestor(Node root, int n, int k) {
        if(root == null) return -1;

        if(root.data == n) {
            return 0;
        }

        int leftSearch = ancestor(root.left, n, k);
        int rightSearch = ancestor(root.right, n, k);

        if(leftSearch == -1 && rightSearch == -1) {
            return -1;
        }

        int max = Math.max(leftSearch, rightSearch);
        if(max+1 == k) {
            System.out.println(k+"th ancestor is: " + root.data);
        }
        return max + 1;
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

       System.out.println("and length to that is: " + ancestor(root, 5, 2));

    }
}
