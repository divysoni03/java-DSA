import java.util.*;

public class mergeBSTs {
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

    public static void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void getInOrder(Node root, List<Integer> nodes) {
        if(root == null) return;

        getInOrder(root.left, nodes);
        nodes.add(root.data);
        getInOrder(root.right, nodes);
    }

    public static Node createBST(List<Integer> arr, int start, int end) {
        if(start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        getInOrder(root1, arr1);
        getInOrder(root2, arr2);
        
        List<Integer> finalArr = new ArrayList<>();

        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                finalArr.add(arr1.get(i++));
            } else {
                finalArr.add(arr2.get(j++));
            }
        }

        while (i < arr1.size()) finalArr.add(arr1.get(i++));
        while (j < arr2.size()) finalArr.add(arr2.get(j++));


        return createBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) {
        /* BST 1
                2
               / \
              1   4
        */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /* BST 2
                9
               / \
              3   12
        */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node finalRoot = mergeBST(root1, root2);

        preOrder(root1);
        System.out.println();
        preOrder(root2);
        System.out.println();
        preOrder(finalRoot);
        System.out.println();
    }
}
