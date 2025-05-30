//count set bits in a number

public class checknumofones {
    public static int find(int n) {
        int count = 0;
        while(n!=0) {
            if((n&1) == 1) { //checking the LSB
                count++;
            }
            n = n>>1; //moving all bits to one step right side
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(find(3));
    }
}
