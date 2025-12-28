import java.util.Stack;

public class pushAtBottom {
    public static void myPush(int data, Stack<Integer> s) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int currVal = s.pop();
        myPush(data, s);
        s.push(currVal);
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
        s.push(2);
        s.push(3);

        System.out.println("\nbefore : ");
        printStack(s);
        s.push(2);
        s.push(3);
        
        myPush(1, s);
        System.out.println("\nafter : ");
        printStack(s);
    }
}
