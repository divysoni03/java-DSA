import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashmapDemo {
    public static void main(String[] args) {
        // regular hashMap
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("india", 50);
        hm.put("china", 50);
        hm.put("USA", 10);

        System.out.println(hm.get("india"));

        // LinkedHashMap : sorted in insertion Order
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("india", 50);
        lhm.put("china", 50);
        lhm.put("USA", 10);

        System.out.println(lhm.get("india"));

        // TreeMap : sorted on keys (put, get, remove O(log n))
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("india", 50);
        tm.put("china", 50);
        tm.put("USA", 10);

        System.out.println(tm.get("india"));
        
    }
}
