/* problem : - given n non-negative integers representing an elevation(height) map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * height will an integer array
 * 
 * height = {4, 2, 0, 6, 3, 2, 5};
 * 
 *  - we will solve this problem using auxiliary array.
 *  - now here the area of water of one bar will be => (water level - bar level) "<-height of the water" * width = trapped water area
 *  
 *  - there will be three cases for bars -> 
 *      1) single bar : no water will be stored
 *      2) two bars : 1.small then big, 2.big then small, 3. both same height
 *      -there will be no water will be stored in both the cases with single bar and two bars
 * 
 *  so for storing the water we need more then two bars
 *   -> backfire case - if the bars are in ascending or descending order where no water will be stored
 *  
 *  - there should be a valley -> area between two bars
 *  - NOW here water level will be => min(max bar level at left, max bar level at right)
 *      and trapped water for any bar = water level - bar height
 * 
 *  - after finding trapped water of every bar then add then to find the total trapped water
 * 
 *  - now the main question remains that how to find max left boundary & max right boundary
 *          - for that we will use auxiliary array which is simple array but we will use that to find these
 *       
 *  - we will make two arrays -> 
 *         height [4, 2, 0, 6, 3, 2, 5]
 *         left max boundary [4, 4, 4, 6, 6, 6, 6] <= finding maximum from iterating left
 *         right max boundary [6, 6, 6, 6, 5, 5, 5] <= finding maximum from iterating right
 */

// -> MY CODE
// public class TrappingRainWater {
//     public static void main(String[] args) {
//         int[] height = {4, 2, 0, 6, 3, 2, 5};
//         int[] left = new int[height.length];
//         int[] right = new int[height.length];


//         // finding the left max Boundary array
//         left[0] = height[0];
//         for(int i=1;i<left.length; i++) {
//             if(left[i-1] < height[i]) {
//                 left[i] = height[i];
//             }else {
//                 left[i] = left[i-1];
//             }
//         }

//         // finding the right max Boundary array
//         right[right.length-1] = height[height.length-1];
//         for(int i=height.length-2;i>=0; i--) {
//             if(right[i+1] < height[i]) {
//                 right[i] = height[i];
//             }else {
//                 right[i] = right[i+1];
//             }
//         }

//         System.out.print("\nleft : ");
//         for(int i:left) {
//             System.out.print(i + " ");
//         }
//         System.out.print("\nright : ");
//         for(int i:right) {
//             System.out.print(i + " ");
//         }
        
//         // finding the trapped water between the max left boundary and right boundary
//         int trappedWater = 0;
//         for(int i=0;i<height.length; i++) {
//             trappedWater += Math.min(left[i], right[i]) - height[i];
//         }

//         System.out.println("\ntotal trapped water : " + trappedWater);
//     }
// }


// -> ORIGINAL CODE
public class TrappingRainWater {

    public static int trappedRainWater(int[] height) {
        int n=height.length;

        // step 1: calculate left max boundary
        int[] left = new int[n];
        left[0] = height[0];
        for(int i=1;i<n; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }

        // step 2: calculate right max boundary 
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        // step 3 : loop for calculating trapped water
        int trappedWater = 0;
        for(int i=0;i<n;i++) {
            // waterLevel = min(leftMaxBound, rightMaxBound)
            int waterLevel = Math.min(left[i], right[i]);

            // trappedWater = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};

        System.out.println("Trapped Water : " + trappedRainWater(height));
    }
}