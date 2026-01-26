import java.util.*;

public class printPath {
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

    public static void print(List<Integer> path) {
        for(int i=0;i<path.size();i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("NULL");
    }
    public static void getPath(Node root, List<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null) {
            print(path);
        }

        getPath(root.left, path);
        getPath(root.right, path);
        
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for(int i: values) {
            root = insert(root, i);
        }

        getPath(root, new ArrayList<>());
        System.out.println();
    }
}
