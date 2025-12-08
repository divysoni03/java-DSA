public class CheckIfArrayIsSorted {
    public static boolean find(int arr[], int i) {
        if(i+1 >= arr.length) {
            return true;
        } else if (arr[i] <= arr[i+1]) {
            return find(arr, i+1);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};

        System.out.println(find(arr, 0)?"Array is sorted :)":"Array is not Sorted :(");
    }    
}
