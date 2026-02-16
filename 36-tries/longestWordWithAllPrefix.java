public class longestWordWithAllPrefix {
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

    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp) {
        if(root == null) return;

        for(int i=0;i<26;i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);
                
                // while backtracking
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "ap", "banana", "app", "appl", "apply", "apple"};

        for(String s: words) insert(s);

        longestWord(root, new StringBuilder());
        System.out.println("Longest word with all prefix: " + ans);
    }
}
