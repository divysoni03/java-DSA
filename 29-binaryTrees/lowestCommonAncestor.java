import java.util.*;

public class lowestCommonAncestor {
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

    public static boolean findPath(Node root, int target, List<Node> path) {
        if(root == null) return false;
        
        path.add(root);
        if(root.data == target) return true;

        if(findPath(root.left, target, path)) { // checking left subTree
            return true;
        }
        
        if(findPath(root.right, target, path)) { // checking right subTree
            return true;
        }

        path.remove(path.size()-1); // if not found both sides return to parent 
        return false;
    }

    public static Node getCommonNode(List<Node> path1, List<Node> path2) {
        int i=0,j=0;
        while(i<path1.size() && j<path2.size()) {
            if(path1.get(i) != path2.get(j)) { // stopping after the last matching node
                break;
            }
            i++;j++;
        }

        return path1.get(i-1); // returning the last matching node
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

       List<Node> path1 = new ArrayList<>();
       findPath(root, 5, path1);
       List<Node> path2 = new ArrayList<>();
       findPath(root, 6, path2);

       Node ancestor = getCommonNode(path1, path2); 

       System.out.println("lowest common ancestor: " + ancestor.data);
    }
}
