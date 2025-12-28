import java.util.Stack;

public class reverseStack {
    public static void myPush(int data, Stack<Integer> s) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int currVal = s.pop();
        myPush(data, s);
        s.push(currVal);
    }

    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) return;

        int val = s.pop();
        reverse(s);
        myPush(val, s); 
    }

    public static void printStack(Stack<Integer> ms) {
        while(!ms.isEmpty()) {
            System.out.println("|  " + ms.peek() + "  |");
            ms.pop();
        }
        System.out.println("-------");
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        printStack(s);

        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);

        printStack(s);
    }
}
