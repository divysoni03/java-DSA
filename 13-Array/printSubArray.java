// sub arrays - a continuous part of array
// i.e. 2 4 6 8 10
// sub array - 2 4 6, not right - 2 4 '8' not consistent

// total no. sub-arrays : (n(n-1))/2

public class printSubArray {
    public static void main(String[] args) {
        int [] arr = {2, 4, 6, 8, 10};

        int ts=0;
        
        for(int i=0;i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total sub Arrays : " + ts);
    }
}
