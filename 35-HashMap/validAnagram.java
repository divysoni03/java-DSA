import java.util.HashMap;

public class validAnagram {
    public static boolean isValid(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(freq, 0) + 1);
        }

        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            if(freq.containsKey(ch)) {
                if(freq.get(ch) == 1) {
                    freq.remove(ch);
                } else freq.put(ch, freq.get(ch) - 1);
            } else return false;
        }

        return freq.isEmpty();
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "cared";

        System.out.println(isValid(s, t));
    }
}