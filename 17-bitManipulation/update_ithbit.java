public class update_ithbit {
    public static int set(int n, int i) {
        return n = (n | (1<<i));
    }
    public static int clear(int n, int i) {
        return n & (~(1<<i));
    }
    public static int find(int n, int i, int s) {
        if(s == 0) {
            return clear(n, i);
        }
        return set(n, i);
    }
    public static void main(String[] args) {
        
    }
}
