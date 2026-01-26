public class AvlTrees {
    static class Node{
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    public static Node root = null;

    public static int getHeight(Node root) {
        if(root == null) return 0;

        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null) return 0;

        return getHeight(root.left) - getHeight(root.right);
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // make rotations
        y.left = x;
        x.right = T2;

        // update the heights of Node 
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y; // new root
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // make rotations
        x.right = y;
        y.left = T2;

        // update the height
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return x; // new root
    }
    
    public static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(key < root.data) {
            root.left = insert(root.left, key);    
        } else if(key > root.data) {
            root.right = insert(root.right, key);
        } else { // duplicate occurred
            return root; // don't add and return the root
        }

        // update the height
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        // after adding which backtracking check for the bad balance Factor(BF)
        int bf = getBalance(root);

        if(bf > 1 && key < root.left.data) { // LL case
            return rightRotate(root);
        }
        if(bf < -1 && key > root.right.data) { // RR case
            return leftRotate(root);
        }

        if(bf > 1 && key > root.left.data) { // LR case
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if(bf < -1 && key < root.right.data) { // RL case
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
        System.out.println();
    }
}
