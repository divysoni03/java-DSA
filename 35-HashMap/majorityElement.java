import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i: arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for(Integer i: freq.keySet()) {
            if(freq.get(i) >= (arr.length / 3)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }
}