// O(n)

public class InsertionSort {

    public static void selectionSort(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            int curr = arr[i];
            int prev = i-1;

            //finding out the correct position of the element
            while(prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev+1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }    
}
