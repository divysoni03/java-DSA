import java.util.*;
import java.util.LinkedList;

public class topViewOfTree {
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
    static class Info {
        Node node;
        int hd; // horizontal distance

        Info(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        Map<Integer, Node> hm = new HashMap<>();

        int max=0, min=0; // minimum ans maximum hd

        q.add(new Info(0, root));
        q.add(null);

        while(!q.isEmpty()) {
            Info currInfo = q.remove();

            if(currInfo == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!hm.containsKey(currInfo.hd)) { // first time occurring 
                    hm.put(currInfo.hd, currInfo.node);
                }

                if(currInfo.node.left != null) {
                    q.add(new Info(currInfo.hd-1, currInfo.node.left));
                    min = Math.min(currInfo.hd-1, min);
                }

                if(currInfo.node.right != null) {
                    q.add(new Info(currInfo.hd+1, currInfo.node.right));
                    max = Math.max(currInfo.hd+1, max);
                }
            }
        }

        for(int i=min; i<=max;i++) {
            System.out.print(hm.get(i).data + ", ");
        }
        System.out.println();
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
    //    Node root = new Node(1);
    //    root.left = new Node(2);
    //    root.right = new Node(3);
    //    root.left.left = new Node(4);
    //    root.left.right = new Node(5);
    //    root.right.left = new Node(6);
    //    root.right.right = new Node(7);

        /*
                    1
                   / \
                  2   3
                   \
                    4
                     \
                      5
                       \
                        6
        
            output: 2, 1, 3, 6,
        */
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.right = new Node(4);
       root.left.right.right = new Node(5);
       root.left.right.right.right = new Node(6);


       topView(root);
    }
}
