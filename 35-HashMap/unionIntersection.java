import java.util.HashSet;

public class unionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {9, 3, 7};
        int[] arr2 = {7, 3, 9, 6, 2, 4};

        HashSet<Integer> hs = new HashSet<>();

        // union
        for(int i: arr1) hs.add(i);
        for(int i: arr2) hs.add(i);

        System.out.print("Union: ");
        for(Integer i: hs) {
            System.out.print(i + ", ");
        }

        hs.clear(); // removes all the elements

        // intersection
        for(int i: arr1) hs.add(i);
        int count=0;

        System.out.print("Intersection: ");
        for(int i=0;i<arr2.length;i++) {
            if(hs.contains(arr2[i])) {
                System.out.print(arr2[i]+", ");
                count++;
                hs.remove(arr2[i]);
            }
        }
        System.out.println("\ntotal common elements: " + count);
    }
}
