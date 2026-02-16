public class uniqueSubStrings {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                this.children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void addSuffix(String word) {
        for(int i=0;i<word.length();i++) {
            String subStr = word.substring(i);
            insert(subStr);
        }
    }

    public static int countNodes(Node root) {
        if(root == null) return 0;

        Node curr = root;
        int count = 0;
        for(int i=0;i<26;i++) {
            if(curr.children[i] != null) {
                count += countNodes(curr.children[i]);
            }
        }

        return count+1;
    }
    public static void main(String[] args) {
        addSuffix("ababa");

        System.out.println(countNodes(root));
    }
}
