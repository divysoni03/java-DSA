// convert first letter of every word to upper case (convert given string to camel case)

public class convertFirstLetterToUC {
    public static void main(String[] args) {
        String s1 =  "hello world";
        //making a string builder so we can use append operation fast
        StringBuilder sb = new StringBuilder( "");

        //adding the first character because there is not space before it.
        char ch = Character.toUpperCase(s1.charAt(0));
        sb.append(ch);

        for(int i=1;i<s1.length(); i++) {
            if(s1.charAt(i) == ' ' && i<s1.length()-1) {
                //appending the space ' ' character
                sb.append(s1.charAt(i));
                i++; // incrementing i to the next character which should be a uppercase
                sb.append(Character.toUpperCase(s1.charAt(i))); //adding the changed char
            }
            else { // adding the char, which are the normal chars
                sb.append(s1.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
