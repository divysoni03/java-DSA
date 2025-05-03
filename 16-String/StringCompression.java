// O(n)

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbccccd";
        StringBuilder ans = new StringBuilder("");

        for(int i=0;i<s.length();i++) {
            Integer count = 1;

            //finding the count of consecutive same characters
            while(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                count++;i++;
            }

            //after that adding the character to the answer string
            ans.append(s.charAt(i));

            if(count > 1) {
                ans.append(count.toString());
            }
        }

        System.out.println(ans);
    }
}
