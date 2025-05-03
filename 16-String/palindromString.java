public class palindromString {
   public static void main(String[] args) {
        String str = "race car";
        String str2 = str.replaceAll("\\s", "").toLowerCase(); // Remove spaces and convert to lowercase
        for(int i=0;i< str2.length()/2;i++){
            if(str2.charAt(i) != str2.charAt(str2.length()-1-i)){
                System.out.println("\n\nNot a palindrome");
                return;
            }
        }
        System.out.println("\n\nPalindrome");
   } 
}
