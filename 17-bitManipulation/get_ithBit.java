// just like we did in the odd even problem
// we will change position LSB in 1 to the i which we get and & it with our number 
/*
 * i = 2
 * index   3210
 * n - 5 - 0101
 * 1<<2    0100 (1- 0001)
 * now &   0100 > 1 means i th bit is = 1.
 * 
 */


public class get_ithBit {
    public static void getithbit(int n, int i) {
        if((n & (1<<i)) >= 1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
    public static void main(String[] args) {
        getithbit(5, 2);
    }    
}
