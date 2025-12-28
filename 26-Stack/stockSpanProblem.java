import java.util.Stack;

// very IMP ques
public class stockSpanProblem {
    public static void makeSpan(int[] stocks, int[] spans) {
        Stack<Integer> s = new Stack<>();
        spans[0] = 1;
        s.push(0);

        for(int i=1;i<stocks.length;i++) {
            int currPrice = stocks[i];

            while(!s.isEmpty() && stocks[s.peek()] <= currPrice ) { // stocks[s.peek()] <- prevHigher price
                s.pop(); // if prev high is less than or equal to curr price than remove that index from the stack
            }

            if(s.isEmpty()) {
                spans[i] = i+1; 
            } else {
                int prevHigh = s.peek();
                spans[i] = i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] spans = new int[stocks.length];

        makeSpan(stocks, spans);
        for(int i: spans) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}