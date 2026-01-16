import java.util.*;
import java.util.LinkedList;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {
        static int idx = -1;

        public static Node build(int[] nodes) {
            idx++;
            if (nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return; // tree is empty then print nothing

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    public static int heightOfTree(Node root) {
        if (root == null) { // base case
            return 0;
        }

        int lh = heightOfTree(root.left); // height of left subTree
        int rh = heightOfTree(root.right); // right subTree

        return Math.max(lh, rh) + 1;
    }

    public static int countNumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int lCount = countNumOfNodes(root.left);
        int rCount = countNumOfNodes(root.right);

        return lCount + rCount + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // O(n^2)
    public static int diameterOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        // diameters
        int leftDiameter = diameterOfTree(root.left);
        int rightDiameter = diameterOfTree(root.right);

        // self diameter
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        // returning max among three (leftDiameter, rightDiameter, curr/self Diameter)
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // O(n) - my approach
    static Map<Node, Integer> Height = new HashMap<>();
    static {
        Height.put(null, 0);
    }
    public static int diameterOfTree2(Node root) {
        if(root == null) {
            return 0;
        }

        // diameters 
        int leftD = diameterOfTree2(root.left);
        int rightD = diameterOfTree2(root.right);

        int leftH = BinaryTree.Height.get(root.left);
        int rightH = BinaryTree.Height.get(root.right);

        int selfD = leftH + rightH + 1;

        BinaryTree.Height.put(root, Math.max(leftH, rightH) + 1);

        return Math.max(selfD, Math.max(leftD, rightD));
    }

    // O(n) - apn clg approach
    static class Info{
        int diam;
        int height;

        Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }
    public static Info diameterOfTree3(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info left = diameterOfTree3(root.left);
        Info right = diameterOfTree3(root.right);
        
        int selfDiam = left.height + right.height + 1;

        int currDiameter = Math.max(Math.max(left.diam, right.diam), selfDiam);
        int currHeight = Math.max(left.height, right.height) + 1;

        return new Info(currDiameter, currHeight);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, 7, -1, -1 };

        Node root = Tree.build(nodes);

        // System.out.println(root.data);
        // System.out.println(root.right.right.right.data);

        // inOrder(root);
        // System.out.println();

        // levelOrder(root);

        // System.out.println("height of Tree: " + heightOfTree(root));

        // System.out.println("Num of nodes in Tree: " + countNumOfNodes(root));

        // System.out.println("Sum of all Nodes: " + sumOfNodes(root));

        // System.out.println("maximum diameter in the Tree O(n^2): " + diameterOfTree(root));

        // System.out.println("maximum diameter in the Tree O(n): " + diameterOfTree2(root));


        Info ans = diameterOfTree3(root);
        System.out.println("maximum diameter: " + ans.diam);
        System.out.println("maximum height: "+ ans.height);
    }
}
