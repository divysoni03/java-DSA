public class heapSort {
    public static void heapify(int[] arr, int i, int size) {
        int left = 2*i+1; // left child
        int right = 2*i+2; // right child

        int maxIdx = i; // curr Root

        if(left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void sort(int[] arr) {
        // step 1: build max heap
        int n = arr.length;
        for(int i=n/2;i>=0;i--) {
            heapify(arr, i, n); // calling heapify for all the non-leaf node to make max heap
        }

        // step 2: swap largest and last ele and re heapify
        for(int i=n-1;i>0;i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3};

        sort(arr);

        for(int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }  
}
