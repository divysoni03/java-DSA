public class FindLastOccurrence {
    //mycode
    // public static int find(int arr[], int key, int i) {
    //     if(i < 0 ) return -1;
    //     if(arr[i] == key) return i;
    //     return find(arr, key, i-1);
    // }

    public static int find(int arr[], int key, int i) { 
        if(i == arr.length) return -1;
        int isFound = find(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) return i;

        return isFound; 
    }
    /*It goes to the end of the array first (recursive calls).
        When it comes back (backtracking), it checks:
        If the value was already found earlier (isFound != -1), return that.
        If nothing was found (isFound == -1) and current element matches key, return the current index.
        That means it returns the first matching index from the end → last occurrence. 
    */

    public static void main(String[] args) {
        // int arr[] = {71,24,69,5,71,53,71,34,54,21,13,4,13,4,134,12};
        int arr[] = {8,3,6,9,5,10,2,5,3};

        System.out.println(find(arr, 5, 0));
    }
}
