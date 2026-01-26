public class printInRange {
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

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void print(Node root, int k1, int k2) {
        if(root == null) return;

        if(k1 <= root.data && root.data <= k2) {
            print(root.left, k1, k2);
            System.out.print(root.data + " ");
            print(root.right, k1, k2);
        } else if(k2 < root.data) {
            print(root.left, k1, k2);
        } else { // k1 > root.data
            print(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for(int i: values) {
            root = insert(root, i);
        }

        print(root, 5, 12);
        System.out.println();
    }
}
