import java.util.HashMap;

public class findItinerary{
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revHm = new HashMap<>();

        for(String s: tickets.keySet()) {
            revHm.put(tickets.get(s), s);
        }

        for(String s: tickets.keySet()) {
            if(!revHm.containsKey(s)) {
                return s; // return start place
            }
        }

        return null;
    }
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");


        String start = getStart(tickets);

        System.out.print(start);
        for(int i=0;i<tickets.keySet().size();i++) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}