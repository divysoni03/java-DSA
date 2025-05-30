/* Here we are guessing the exponent value as binary value
    so as we know if EX is 5 - 1    0    1
 *                             2^2  2^1  2^0 = 4+0+1 = 5
 *  just like this concept we will use the base number as like that 2
 *  ex., 
 *          3^3
 * then exponent 3 - 011 (binary)
 *      0   1   1
 *      3^3 3^2 3^1 = 9 * 3 = 27 (multiply all who have bit 1) (don't consider which have bit 0)
 */

public class fastExponentiation {
    public static int find(int a, int e) {
        int ans = 1;
        while(e > 0) {
            if((e&1) == 1) { //checking the LSB if one then multiply which ans
                ans *= a;
            }
            a = a*a; //square - just like binary each position will have different squares (we will multiply only specific positions)
            e = e>>1; //right shift to the check next bit
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(find(3, 3));
    }
}
