import java.util.HashMap;

public class largestSubArrWithSumZero {
    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLen = 0, sum = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("largest subArr with sum Zero: " + maxLen);
    }
}
