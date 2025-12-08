package ques;

/* que:1 for a given integer array of size N. you have to find all the
 * occurrences(indices) of a given element(key) and print them. use a 
 * recursive function to solve this problem.
 * 
 * input = {3,2,4,5,6,2,7,2,2}, key = 2
 * output = 1, 5, 7, 8
*/
public class Que1 {
    public static void find(int arr[], int key, int idx) {
        if(idx == arr.length) {
            return;
        }
        if(arr[idx] == key) {
            System.out.print(idx + " ");
        }
        find(arr, key, idx+1);
    }
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,6,2,7,2,2};
        find(arr, 2, 0);
    }
}
