import java.util.*;

public class balanceTheBST {
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
    
    public static void inOrder(Node root, List<Integer> nodes) {
        if(root == null) return;

        inOrder(root.left, nodes);
        nodes.add(root.data);
        inOrder(root.right, nodes);
    }

    public static Node createBST(List<Integer> arr, int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    public static Node balanceBST(Node root) {
        List<Integer> arr = new ArrayList<>();

        inOrder(root, arr);

        return createBST(arr, 0, arr.size()-1);
    }

    public static void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        /*
                            8
                           / \
                          6   10
                         /      \
                        5        11
                       /           \
                      3             12
        */
       Node root = new Node(8);
       root.left = new Node(6);
       root.left.left = new Node(5);
       root.left.left.left = new Node(3);
       root.right = new Node(10);
       root.right.right = new Node(11);
       root.right.right.right = new Node(12);


       root = balanceBST(root);
       preOrder(root);
       System.out.println();
       /*
                    8
                   / \
                  5   11
                 / \  / \
                3  6 10 12 
        */
    }
}
