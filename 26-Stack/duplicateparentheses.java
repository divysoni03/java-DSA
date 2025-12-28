import java.util.Stack;

public class duplicateparentheses {
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for(char i: str.toCharArray()) {
            // we will only focus on closing bracket and everything other then that will get pushed in stack
            if(i == ')') {
                int count=0;
                while(s.peek() != '(') {
                    count++;s.pop();
                }
                if(count<1) {
                    return true;
                } else {
                    s.pop(); // popping the opening bracket "("
                }
            } else { // in case of opening bracket, operator and expression
                s.push(i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b))";
        // String str2 = "(a+b)";
        if(isDuplicate(str1)) {
            System.out.println("input : " + str1 + "\nhave duplicate parentheses");
        } else {
            System.out.println("input : " + str1 + "\nDoesn't have duplicate parentheses");
        }
    }
}
