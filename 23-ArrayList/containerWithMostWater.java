import java.util.ArrayList;
import java.util.List;

public class containerWithMostWater {
    // my code in first time (same as trapping rain water)
    public static int find(ArrayList<Integer> heights) {
        int n = heights.size();

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = heights.get(0);
        for(int i=1;i<n;i++) {
            left[i] = Math.max(left[i-1], heights.get(i));
        }

        right[n-1] = heights.get(n-1);
        for(int i=n-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], heights.get(i));
        }

        int maxWater = Integer.MIN_VALUE;
        int i=0, j=n-1;
        while(i<j) {
            int width = j-i;
            int height = Math.min(left[i], right[j]);
            if(maxWater < (width * height)) {
                maxWater = width * height;
            }
            
            if(left[i] > right[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxWater;
    }

    // brute force approach O(n^2)
    // public static int findBruteForce(ArrayList<Integer> heights) {
    //     int n= heights.size();
    //     int maxWater = Integer.MIN_VALUE;
    //     int width = 0, height = 0;
    //     for(int i=0;i<n-1; i++) {
    //         for(int j=i+1;j<n;j++) {
    //             height = Math.min(heights.get(i), heights.get(j));
    //             width = j-1;
    //             if(maxWater < (width * height)) {
    //                 maxWater = (width * height);
    //             }
    //         }
    //     }
    //     return maxWater;
    // }

    // two pointer approach (without extra space)
    public static int storeWater(ArrayList<Integer> heights) {
        int maxWater = 0;
        int lp = 0, rp = heights.size() -1;

        while(lp < rp) {
            // calculate the currently containing water
            int height = Math.min(heights.get(lp), heights.get(rp));
            int width = rp - lp;
            int currWater = height * width;

            maxWater = Math.max(maxWater, currWater);

            // updating the pointers
            if(heights.get(lp) < heights.get(rp) ) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }

    public static void printArr(int[] arr) {
        for(int i: arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.addAll(List.of(1,8,6,2,5,4,8,3,7));
        System.out.println("\nContainer with most water : " + storeWater(heights));
    }
}
