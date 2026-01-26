public class validateBST {
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

    public static boolean isValid(Node root, Node min, Node max) {
        if(root == null) return true;

        if(min != null && root.data <= min.data) {
            return false;
        } else if(max != null && root.data >= max.data) {
            return false;
        }

        boolean left = isValid(root.left, min, root);
        boolean right = isValid(root.right, root, max);

        return left && right;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        // root.left.right = new Node(6); 

        if(isValid(root, null, null)) {
            System.out.println("Tree is Valid BST");
        } else {
            System.out.println("Tree is Not a Valid BST");
        }
    }
}
