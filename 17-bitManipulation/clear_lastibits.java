// we can use 1 and shift it for given index and reverse it
// 15 - 1111

//  1 - 0001
// ~1 - 1110
//~1<<2 - 1000


// now ; 
//    15 - 1111
// ~1<<2 - 1000
//       & 1000 = 8

public class clear_lastibits {
    public static int find(int n, int i) {
        return n & ((~1)<<i);
    }
    public static void main(String[] args) {
        System.out.println(find(15, 2));
    }
}
