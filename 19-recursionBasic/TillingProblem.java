// amazon

/* Given "2 * n" board and tiles of size "2 * 1", count the number of ways to tile the given board using the 2 * 1 tiles.
 * ( A tile can either be placed horizontally or vertically.)
 */

 /* base: if height 0 <- 1 way which is to place no tile, 1 <- 1 way place it vertically
  * choice 1: can place tile vertically
  * choice 2: place 2 tiles horizontally
  */
public class TillingProblem {
    public static int find(int n) { // 2 breadth x n length (total floor size)
        // base case
        if(n == 0 || n == 1) return 1;

        // if place vertically then how many ways
        int vertically = find(n - 1); // only one will be deducted from length

        // if placed horizontally then how many ways
        int horizontally = find(n-2); // 2 will be deducted from the length when 2 tile is placed horizontally

        // returning total ways 
        return vertically + horizontally;
    }

    public static void main(String[] args) {
        System.out.println("ans : " + find(5));
    }
} 
