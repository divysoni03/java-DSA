public class ExtraQuestion {
    public static void main(String[] args) {
        //1. swap without any third variable
        int a = 10;
        int b = 20;

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println(a + " " + b);

        //2. add 1 in any integer using bit wise operator
        int x = 10;
        x = ~x * -1;
        System.out.println(x); 
        x = ~x * -1;
        System.out.println(x); 

        //3. convert uppercase to lowercase
        char ch = 'C';
        System.out.println((char)(ch | ' '));
    }
}
