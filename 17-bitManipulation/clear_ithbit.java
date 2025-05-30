public class clear_ithbit {
    public static int find(int n, int i) {
        return n & (~(1<<i));
    }
    public static void main(String[] args) {
        System.out.println(find(7, 1));
    }
}
