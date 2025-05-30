//check if number is power of two or not 
/*
 * 4 - 2^2 true
 * 8 - 2^3 true
 * 7 - false
 */

 /*
  * 4 - 100
    3 - 011
      & 000


    16 - 10000
    15 - 01111
       & 00000

    PATTERN - N & (N-1)
  */

public class checkifanumispoweroftwo {
    public static boolean find(int n) {
        return (n & (n-1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(find(256));
    }
}