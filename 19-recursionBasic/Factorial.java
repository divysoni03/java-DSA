public class Factorial {
    public static int find(int n) {
        if(n==0 || n==1 ) return 1;
        return n * find(n-1);
    }

    public static void main(String[] args) {
        System.out.println(find(5));
    }    
}
