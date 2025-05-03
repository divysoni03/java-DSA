// problem - sum of sub array-
//  using 3 technique : 
//      - brute force
//      - prefix
//      - kadane's algo


// // brute-force ( Time-complexity : O(n^3) )
// public class maxSubArraySum {
//     public static void main(String[] args) {
//         int arr[] = {1, -2, 6, -1, 3};

//         int max = Integer.MIN_VALUE;

//         for(int i=0;i<arr.length; i++) {
//             for(int j=i; j<arr.length; j++) {
//                 int sum = 0;
//                 for(int k=i; k<=j; k++) {
//                     sum += arr[k];
//                 }
//                 if(max < sum) {
//                     max = sum;
//                 }
//                 // System.out.print(sum+ " ");
//             }
//             // System.out.println();
//         }

//         System.out.println("Max Sub-array sum : " + max);
//     }
// }



/* prefix : O(n^2)  
    in this solution we make another array and store sum of the sub array to that index
    prefix array - (1<- sum till index 0, -1 <- sum till index 1, 5, ...)

    formula to find any sum from prefixSum array : prefix[end]-prefix[start-1] 
// */
// public class maxSubArraySum {
//     public static void main(String[] args) {
//         int arr[] = {1, -2, 6, -1, 3};
        
//         int max = Integer.MIN_VALUE;
//         int prefixSum[] = new int[arr.length];

//         // calculating the prefix array which will contain sum till the index

//         // the first index will have sum till first index means element itself 
//         prefixSum[0] = arr[0];
//         for(int i=1;i<prefixSum.length; i++) {
//             the sum of next index will have sum of previous element(which is sum till that index) and sum of current element
//             prefixSum[i] = prefixSum[i-1] + arr[i];
//         }

//         for(int i=0;i<arr.length; i++) {
//             for(int j=i; j<arr.length; j++) {
//                 int sum = (i == 0)? prefixSum[j]:prefixSum[j]-prefixSum[i-1];
//                 if(max < sum ) {
//                     max = sum;
//                 }
//             }
//             // System.out.println();
//         }

//         System.out.println("Max of subArray : " + max);
//     }
// }

/* kadane's algo O(n) :

-> kadane says that when we add one small positive no and big negative no = always will be big negative number
so rather then calculating it we will return 0 in this case

there will be two var : 1) cs-current sum, ms-max sum
    - here we will go through every element and calculate cs and ms.
    - we will add elements in the cs, when the cs gets negative then we will make it zero and start again. while we will also update the ms along the way.


    arr -2 -3  4 -1 -2  1  5 -3
    cs   0  0  4  3  1  2  7  4
    ms   0  0  4  4  4  4  7 '7'<= max

    -so the maximum sum of the sub array is 7 


*/
public class maxSubArraySum {

    public static void kadanes(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i: numbers) {
            cs += i;
            if(cs < 0) {
                cs = 0;
            }
            ms = Math.max(ms, cs);
        }

        System.out.println("MAX : " + ms);
    }

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        kadanes(arr);
    }
}
