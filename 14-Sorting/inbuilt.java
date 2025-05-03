// O(n log n)
import java.util.Arrays;

public class inbuilt {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        Arrays.sort(arr);
        // Arrays.sort(arr, startingIndex, endingIndex);
        // Arrays.sort(arr, Collections.reverseOrder()); // works with Integer object array
        // Arrays.sort(arr, si, ei, Collections.reverseOrder());

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
