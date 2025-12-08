package ques;

/* que:3 write a program to find length of a string using recursion */
public class Que3 {
    public static int find(String str,int size) {
        if(str.charAt(size) == '\n') {
            return size;
        }
        return find(str, size+1);
    }
    public static void main(String[] args) {
        System.out.println(find("hello world\n", 0));
    }
}


/* original code

public static int length(String str) {
    if(str.length() == 0) {
        return 0;
    }
    return length(str.substring(1)) + 1;
}

*/