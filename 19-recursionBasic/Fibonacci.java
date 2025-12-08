//finding Nth number of the fibonacci series 

public class Fibonacci {
    public static int find(int n) {
        if(n==0 || n==1 ) return n;
        return find(n-1) + find(n-2);
    }

    public static void main(String[] args) {
        System.out.println(find(5));
    }
}
