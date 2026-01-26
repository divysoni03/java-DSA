public class mirrorBST {
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

    // my code O(n)
    public static void mirror(Node root) {
        if(root == null) return;

        if(root.left != null && root.right != null) {
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if(root.left != null) {
            root.right = root.left;
            root.left = null;
        } else if(root.right != null) {
            root.left = root.right;
            root.right = null;
        }

        mirror(root.left);
        mirror(root.right);
    }

    // apn clg code O(n)
    public static Node createMirror(Node root) {
        if(root == null) return null;

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        inOrder(root);
        System.out.println();
        mirror(root);
        inOrder(root);
        System.out.println();
    }
}
