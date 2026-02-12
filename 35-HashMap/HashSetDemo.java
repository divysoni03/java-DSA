import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo{
    public static void main(String[] args) {
        // regular hash set
        HashSet<String> hs = new HashSet<>();

        hs.add("india");
        hs.add("china");
        hs.add("USA");

        System.out.println(hs);

        // LinkedHashSet : sorted in insertion Order
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("india");
        lhs.add("china");
        lhs.add("USA");

        System.out.println(lhs);

        // TreeSet : sorted on keys (insert, remove O(log n))
        TreeSet<String> ts = new TreeSet<>();

        ts.add("india");
        ts.add("china");
        ts.add("USA");

        System.out.println(ts);

        // 1. iteration in set
        Iterator<String> i = hs.iterator();
        while(i.hasNext()) {
            System.out.print(i.next() + ", ");
        }
        
        for(String c: hs) {
            System.out.print(c + ", ");
        }
    }
}
