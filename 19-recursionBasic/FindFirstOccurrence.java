public class FindFirstOccurrence {
    public static int find(int arr[], int key, int i) {
        if(arr[i] == key) return i;
        if(i >= arr.length) return -1;
        return find(arr, key, i+1);
    }
    public static void main (String[] args ) {
        int arr[] = {10,22,13,49,14,1,52,21,11,31,46};

        System.out.println("index : " + find(arr, 1, 0));
    }
}
