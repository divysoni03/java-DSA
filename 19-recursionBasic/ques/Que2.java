package ques;

/*que:2 you are given a number (eg., 2019), convert it into a
 * string of english like "two zero one nine". use a recursive func
 * to solve this problem
 * 
 * Note: digit of the number will only be in the range 0-9, last
 * digit of a number can't be zero
 *
*/
public class Que2 {
    public static void find(int number, String[] digits) {
        if(number == 0) {return;}
        find(number/10, digits);

        int digit = number % 10;
        System.out.print(digits[digit]+" ");  
    }
    public static void main(String[] args) {
        String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        find(1947, digits);
    }
}
