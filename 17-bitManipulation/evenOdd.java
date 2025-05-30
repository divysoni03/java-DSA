//every odd numbers least significant bit is always 1
//0 - 000
//1 - 001
//2 - 010
//3 - 011

//3 -  011
//1 - &001
//       1(true)


//where the 1 which we used to do bit wise and - is call bitMask

public class evenOdd {

    public static void find(int n) {
        if((n & 1) == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
    public static void main(String[] args) {
        find(3);
        find(4);
        find(5);
        find(6);
    }    
}
