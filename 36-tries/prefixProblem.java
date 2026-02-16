import java.util.*;

public class prefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for(int i=0;i<children.length;i++) {
                this.children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void makePrefix(List<String> prefix, String[] words) {
        for(String word: words) {
            Node curr = root;
            StringBuilder currPrefix = new StringBuilder();
            for(int i=0;i<word.length();i++) {
                currPrefix.append(word.charAt(i));
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] != null && curr.children[idx].freq == 1) {
                    break;
                }
                curr = curr.children[idx];
            }
            prefix.add(currPrefix.toString());
        }
    }

    public static void main(String[] args) {
        String[] words = {"zebra", "dog", "duck", "dove"};

        List<String> res = new ArrayList<>();

        for(String s: words) insert(s);

        makePrefix(res, words);

        for(String s: res) {
            System.out.print(s+", ");
        }
        System.out.println();
    }
}
