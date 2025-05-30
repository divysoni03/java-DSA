/* 16 8 4 2 1 = 31
 * 1  1 1 1 1
 * i= 1 to j = 3
 * 1 0 0 0 1 = 17
 */

public class clear_rangeofbits {
    public static int find(int n, int i, int j) {
        int a = (~0)<<(j+1);
        int b = (1<<i)-1; // 2^i -1 == odd number which have all the last bits one
        // both a | b makes bit-mask

        return n & (a | b);
    }
    public static void main(String[] args) {
        System.out.println(find(31, 1, 3));
    }
}
