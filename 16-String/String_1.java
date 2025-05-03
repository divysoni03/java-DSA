// import java.util.Scanner;

public class String_1 {
    public static void main(String[] args) {
    //    char arr[] = {'a', 'b', 'c', 'd', 'e'};
    //    String str = "abcde";
    //    String str2 = new String("abcde");

    //    for(char s : arr) {
    //        System.out.println(s);
    //    }
    //     System.out.println(str +" "+ str2);

    //     Scanner sc = new Scanner(System.in);
    //     String name;
    //     // name = sc.next(); //only takes input till it finds space
    //     System.out.println("Enter your name: ");
    //     name = sc.nextLine(); //takes input till 'next-line-char'

    //     System.out.println("Hello " + name);
    //     //length function
    //     System.out.println("Length of the string is: " + name.length());

    //     String firstName = "divy";
    //     String lastName = "soni";

    //     String fullName = firstName + " " + lastName;
    //     System.out.println("Full name is: " + fullName);

    //     fullName = firstName.concat(" ").concat(lastName);
    //     System.out.println("Full name is: " + fullName);
    
    //     String s1 = "tony";
    //     String s2 = "tony";

    //     String s3 = new String("tony");
        // s1 == s2 true but s1 == s3 not true because when we make this without new keyword the s2 will be pointing to the same s1 location that's why same
        // and when we make a new string with new keyword then its not possible to directly compare those two
        // that's why 
        // if(s1.equals(s3)) {
        //     System.out.println("true");
        // }

        // substring function
        String s1 = "hello world!";
        System.out.println(s1.substring(3));
    }
} 