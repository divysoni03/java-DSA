// O(n)

/*
-> simple bubble sort algorithm :-

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        for(int i=0;i< arr.length-1; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        bubbleSort(arr);

        for(int i:arr) {
            System.out.print(i+" ");
        }
    }    
}
*/

public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        long startTime = System.nanoTime();

        for(int i=0;i< arr.length-1; i++) {
            int swaps = 0;
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0) {
                break; // already sorted
            }
        }

        long endTime = System.nanoTime();
        System.out.println("Total time : " + ((endTime-startTime)) + "ns");
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        bubbleSort(arr);
    }
}