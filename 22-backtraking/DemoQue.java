/** if we have one array we will store 1,2,3,4,5
 * in array using recursion but while coming back after
 * hitting the base case we have to decrease the value
 * of element in the array by 2.
 */
public class DemoQue {
    public static void change(int [] arr, int i, int val) {
        //base case
        if(i == arr.length) {
            printArray(arr); // printing after going all in
            return;
        }

        //recursion
        arr[i] = val; // while going up
        change(arr, i+1, val+1);
        arr[i] -= 2; // while coming back
    }

    public static void printArray(int[] arr) {
        for(int i:arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        change(arr, 0, 1);
        printArray(arr); // printing after coming back
    }
}
