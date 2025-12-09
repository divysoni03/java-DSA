public class QuickSort {
    public static void quickSortFunc(int arr[], int si, int ei) {
        //base case
        if(si >= ei) return;

        // work
        int pivotIndex = partition(arr, si, ei); // finding position of pivot that we have selected
        // applying quickSort for left and right subArr of pivot index
        quickSortFunc(arr, si, pivotIndex - 1);
        quickSortFunc(arr, pivotIndex + 1, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // selecting pivot
        int i = si - 1;

        // putting element less than pivot on left side and more than pivot on right side
        for(int j=si; j<=ei; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        // swapping values to put pivot to it's right position
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i; // returning index of the pivot
    }


    public static void printArr(int arr[]) {
        for(int i: arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {6,4,1,3,5,6,7,1,12,0};
        quickSortFunc(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
