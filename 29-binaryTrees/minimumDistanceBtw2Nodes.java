public class minimumDistanceBtw2Nodes {
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
        if(root == null || root.data == n1 || root.data == n2) return root;

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(rightLCA == null) return leftLCA;
        if(leftLCA == null) return rightLCA;

        return root;
    }

    public static int lcaDistance(Node root, int n) {
        if(root == null) return -1;

        if(root.data == n) return 0;

        int leftSearch = lcaDistance(root.left, n);
        int rightSearch = lcaDistance(root.right, n);

        if(leftSearch == -1 && rightSearch == -1) {
            return -1;
        } else if(leftSearch == -1) {
            return rightSearch + 1;
        } else {
            return leftSearch + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = LCA(root, n1, n2);
        
        return lcaDistance(lca, n1) + lcaDistance(lca, n2);
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


       System.out.println("min distance: " + minDist(root, 4, 6));
    }
}
