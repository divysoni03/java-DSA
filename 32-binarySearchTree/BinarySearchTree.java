public class BinarySearchTree {
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

    public static Node insert(Node root, int val) {
        if(root == null) {
            Node newNode = new Node(val);
            root = newNode;
            return root;
        }

        if(val < root.data) { // left subTree
            root.left = insert(root.left, val);
        } else { // right subTree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root == null) return false;

        if(root.data ==  key) return true;

        if(root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i: values) {
            root = insert(root, i);
        }

        inOrder(root);
        System.out.println();

        System.out.println("is present: " + search(root, 10));
    }
}
