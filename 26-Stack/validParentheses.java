import java.util.Stack;

public class validParentheses {
    public static boolean isValidParentheses(String str) {
        if(str.length() == 0) return false;

        Stack<Character> s = new Stack<>();

        for(char ch: str.toCharArray()) {
            // if opening bracket then push to the stack
            if( ch=='(' || ch=='{' || ch=='[' ) s.push(ch);
            else {
                // if only closing brackets are in string so no opening bracket will be in the stack
                if(s.isEmpty()) return false;

                // if condition is true then pop the top element
                if( (ch==')' && s.peek()=='(') 
                    || (ch=='}' && s.peek()=='{') 
                    || (ch==']' && s.peek()=='[') ) {
                         s.pop();
                    }
                // if the required closing bracket in not found then return false
                else return false;
            }
        }

        // after iterating through whole string and still stack is filled with something
        if(!s.isEmpty()) return false;

        return true;
    }
    public static void main(String[] args) {
        // String str = "{[()]()}";
        String str = ")))))";
        if(isValidParentheses(str)) {
            System.out.println("input : " + str + "\nis valid parentheses");
        } else {
            System.out.println("input : " + str + "\nis NOT valid parentheses");
        }
    }
}
