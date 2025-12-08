// print power of x^n


// O(n) - time complexity

// public class power {
//     public static int find(int x, int n) {
//         if(n == 1) return x;
//         return x * find(x, n-1);
//     }
//     public static void main(String[] args) {
//         System.out.println("power answer : " + find(5, 3));
//     }
// }


// optimized O(log n)

// case 1 : x^n (even - n) = x^n/2 * x^n/2
// case 2 : x^n (odd - n)  = x^n/2 *(x^n/2) + 1

/*
 * -> at first we were decresing the value of n by 1 (n-1) which was linear
 * 
 * now we will divide the n/2 and call for n/2 , n/2
 */

 public class power {
    public static int find(int x, int n) {
        if(n == 0) return 1; // base case
        
        // finding for even n 
        int halfPower = find(x, n/2); // finding only one time, so to avoid calling it two time same thing
        int halfPowerSq = halfPower * halfPower;

        // if n is odd then n then multiply this extra x 
        if(n % 2 != 0) {
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }
    public static void main(String[] args) {
        System.out.println("Power : " + find(5, 3));
    }
 }