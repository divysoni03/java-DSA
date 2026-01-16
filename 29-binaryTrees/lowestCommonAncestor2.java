public class lowestCommonAncestor2 {
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

    public static Node LCA(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2); // checking the left subArray
        Node rightLCA = LCA(root.right, n1, n2); // checking the right subArray

        if(rightLCA == null) return leftLCA;
        if(leftLCA == null) return rightLCA;

        // else means both are not NULL -> means we are the nearest neighbor
        return root;
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

       Node ancestor = LCA(root, 4, 5); 

       System.out.println("lowest common ancestor: " + ancestor.data);
    }
}
