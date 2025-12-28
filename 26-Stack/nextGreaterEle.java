import java.util.Stack;

// very important logic 
public class nextGreaterEle {
    public static void find(int[] arr, int[] result) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            // 1. while loop (to remove all the small elements in stack)
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // 2. if else to save the next greater element in result arr
            if(s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = arr[s.peek()];
            }

            // 3. save the curr element in the stack
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] result = new int[arr.length];

        find(arr, result);
        for(int i: result) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}

// 8, -1, 1, 3, -1, 