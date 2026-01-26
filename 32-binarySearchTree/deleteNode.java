public class deleteNode {
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

    public static Node delete(Node root, int target) {
        if(target < root.data) {
            root.left = delete(root.left, target);
        } else if(target > root.data) {
            root.right = delete(root.right, target);
        } else { // found the target

            // case 1: no child
            if(root.left == null && root.right == null) {
                return null;
            }

            // case 2: one child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // case 3: two Children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data+", ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for(int i: values) {
            root = insert(root, i);
        }

        inOrder(root);
        System.out.println();
        root = delete(root, 5);
        inOrder(root);
        System.out.println();
    }
}
