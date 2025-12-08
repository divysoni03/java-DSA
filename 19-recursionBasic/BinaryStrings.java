// paytm

/* binary string problem 
 * string only made of binary numbers
 * print all binary strin of size n without consecutive ones.
 * 
 * ex., "01010", "0000" <- allowed, "010011"<- not allowed
 */

/* n=0 -> ""
 * n=1 -> "0", "1"
 * n=2 -> "00" "10" "01" <-yes ,"11"<-no
 * 
 * if we put 1 at last place then we can't put 1 to current place, to avoid consecutive 1's problem
 * 
 */
public class BinaryStrings {
    public static void findForConsecutive1(int n, int lp, String str) { // n=nth place, lp=last place digit
        if(n==0){
            System.out.println(str);
            return;
        }
        
        // kaam
        // if(lp == 0) {
        //     // placing 0 on nth place 
        //     find(n-1, 0, str.append('0'));
        //     // placing 1 on nth place 
        //     find(n-1, 1, str.append('1'));
        // } else {
        //     // placing 0 if lastplace had 1
        //     find(n-1, 0, str.append('0'));
        // }

        findForConsecutive1(n-1, 0, str+'0');
        if(lp == 0) {
            findForConsecutive1(n-1, 1, str+'1');
        }
    }

    public static void findForConsecutive0(int n, int lp, String str) {
        if(n==0) {
            System.out.println(str);
            return;
        }

        findForConsecutive0(n-1, 1, str+'1');
        if(lp == 1) {  
            findForConsecutive0(n-1, 0, str+'0');
        }
    }

    public static void find(int n, int lp, StringBuilder str) {        
        if(n==0) {
            System.out.println(str);
            return;
        }

        find(n-1, 0, str.append('0'));
        if(lp == 0) {
            find(n-1, 1, str.append('1'));
        }
    }

    public static void main(String[] args) {
        // System.out.println("\nnoconsecutive 1s:");
        // findForConsecutive1(3, 0, "");
        // System.out.println("\nnoconsecutive 0s:");
        // findForConsecutive0(3, 1, "");

        find(3, 0, new StringBuilder(""));
    }
}
