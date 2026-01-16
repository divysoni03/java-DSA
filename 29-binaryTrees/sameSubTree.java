public class sameSubTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Tree {
        static int idx = -1;

        public static Node build(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
    }

    // helper function to check the identical
    public static boolean checkIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) return true;
        else if(root == null || subRoot == null || root.data != subRoot.data) return false;

        if(!checkIdentical(root.left, subRoot.left)) {
            return false;
        }

        if(!checkIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;
        // return checkIdentical(root.left, subRoot.left) && checkIdentical(root.right, subRoot.right);
    }

    // main function to check for the subTree
    public static boolean isSubTree(Node root, Node subRoot) {
        if(root == null) return false;

        if(root.data == subRoot.data) {
            if(checkIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public static void main(String[] args) {
        int[] mainTree = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int[] subTree = {2, 4, -1, -1, 5, -1, -1};

        Node root = Tree.build(mainTree);
        Tree.idx = -1;
        Node subRoot = Tree.build(subTree);

        System.out.println(isSubTree(root, subRoot)?"subTree exists in the Main Tree":"subTree doesn't exists in the Main Tree");
    }
}
