 package ques;

/* que:5 tower of hanoi */
public class Que5 {
    public static void find(int n, char source, char auxilary, char destination ) {
        if(n == 1) {
            System.out.println("n: " + n + " source: " + source + " destination: " + destination);
            return;
        }

        //transfer n-1 disk from source to auxilary rod
        find(n-1, source, destination, auxilary);

        // transfer nth rod source to destination
        System.out.println("n: " + n + " source: " + source + " destination: " + auxilary);

        // transfer n-1 disk from auxilary to destination 
        find(n-1, auxilary, source, destination);
    }
    public static void main(String[] args) {
        find(3, 'A', 'B', 'C');
    }
}
