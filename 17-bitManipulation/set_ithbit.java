// or 1 with any bit to convert it to 1

public class set_ithbit {
    public static int find(int n, int i) {
        return n = (n | (1<<i));
    }
    public static void main(String[] args) {
        System.out.println(find(5, 1));
    }    
}
