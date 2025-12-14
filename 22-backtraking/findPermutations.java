public class findPermutations {
    public static void find(String str, String ans) {
        if(0 == str.length()) {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length(); i++) {
            // first get the curr char
            char curr = str.charAt(i);

            // remove char from the original string
            String newStr = str.substring(0, i) + str.substring(i+1); // "abcde" (if curr char = 'c') = "ab" + "de" = "abde"

            // call for remaining chars
            find(newStr, ans + curr); // also add that chosen char to ans
        }
    }


    public static void main(String[] args) {
        find("abc", "");
    }
}
