import java.util.Stack;

public class maxAreaInHistogram {
    public static void maxArea(int[] heights) {
        int n = heights.length;
        int nsr[] = new int[n]; // next smaller right
        int nsl[] = new int[n]; // next smaller left

        // next smaller right (to find right we go from end to start)
        Stack<Integer> s = new Stack<>();
        for(int i=n-1;i>=0;i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) { // remove greater element till we found the smaller element
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = n; // if no smaller element in right side then make it n(means we included last ele)
            } else {
                nsr[i] = s.peek();
            }
            s.push(i); // add curr idx
        }

        // next smaller left(for left we go from start to end)
        s = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1; // if no smaller element at left side then add -1 (before first ele, means we included first ele)
            } else {
                nsl[i] = s.peek();
            }
            s.push(i); // add curr idx
        }

        // calculate area
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1; // width = j-i-1

            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max Area in histogram is : " + maxArea);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3}; // heights
        maxArea(arr);
    }
}
