public class gridWaysTrick {
    public static int factorial(int n) {
        if(n == 0 || n == 1) return 1;
        return n * factorial(n-1);
    }
    public static int gridWays(int n, int m) {
        int base = factorial(n - 1) * factorial(m - 1);
        return factorial(n + m - 2) / base;
    }
    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println("total ways :"+ gridWays(n, m));
    }
}
