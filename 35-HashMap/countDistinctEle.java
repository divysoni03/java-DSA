import java.util.HashSet;
import java.util.Iterator;

public class countDistinctEle {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 7, 3, 4, 2, 1};

        HashSet<Integer> hs = new HashSet<>();
        for(int i: arr) {
            hs.add(i);
        }

        Iterator<Integer> i = hs.iterator();
        while(i.hasNext()) {
            System.out.print(i.next() + ", ");
        }
    }
}
