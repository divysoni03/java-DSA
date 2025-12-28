import java.util.Stack;

public class reverseString {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();

        for(char i: str.toCharArray()) s.push(i);

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()) {
            result.append(s.pop());
        }

        return result.toString();
    }
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str);
        str = reverse(str);
        System.out.println(str);
    }
}
