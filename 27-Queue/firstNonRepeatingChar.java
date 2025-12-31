import java.util.LinkedList;
import java.util.Queue;

public class firstNonRepeatingChar {
    public static void firstNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(char ch: str.toCharArray()) {
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove(); // remove until queue is empty or we found char with freq 1
            }

            // case 1: queue has become empty
            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else { // case 2: we found the first non repeating char
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        firstNonRepeating(str);
    }
}
