public class printNumInDecreasingOrder {

    public static void decreasingOrder(int n) {
        if(n==0) return;
        System.out.print(n + ", ");
        decreasingOrder(n-1);
    }

    public static void increasingOrder(int n) {
        if(n==0) return;
        increasingOrder(n-1);
        System.out.print(n + ", ");
    }

    public static void main(String[] args ) {
        decreasingOrder(10);
        System.out.println();
        increasingOrder(10);
        System.out.println();
    }
}