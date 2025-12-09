public class mergeSort {
    public static void mergeSortFunc(int arr[], int si, int ei) {
        //base case
        if(si >= ei) return;

        //work
        int mid = si + (ei-si)/2;
        mergeSortFunc(arr, si, mid);
        mergeSortFunc(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // arr to merge two sub arr
        int temp[] = new int[ei-si+1];
        // some iterator 
        int i = si;
        int j = mid+1;
        int k = 0;

        // first work sorting 
        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // adding rest of the elements
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        // copying temp arr to original one
        for(k=0,i=si;k<temp.length;k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]) {
        for(int i: arr) {
            System.out.print(i + ", ");
        }
        System.out.println(11);
    }
    public static void main(String[] args) {
        int arr[] = {6,3,2,0,5,4,1};
        mergeSortFunc(arr, 0, arr.length-1);
        printArr(arr);
    }
}
