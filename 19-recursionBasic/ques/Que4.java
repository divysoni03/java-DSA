package ques;

/* que:4 we are given a string S, we need to find the count of all 
 * continuos substring starting and ending with the same character
 * 
 * s = "abcab"
 * output = {a, abca, b, bcab, c, (a, b)<- second time becuz of diff index}
 * 
 * s="aba"
 * output = {a, b, a<-second time becuz of diff idx, aba)}
 */
public class Que4 {
    public static int countSubstrgs(String str, int i, int j, int n) {
        if(n == 1) return 1;
        if(n <= 0) return 0;

        int res = countSubstrgs(str, i+1, j, n-1) +
                  countSubstrgs(str, i, j-1, n-1) -
                  countSubstrgs(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)) res++;

        return res;
    }

    public static void main(String[] args) {
        String str = "abcab";
        int n = str.length();
        System.out.println(countSubstrgs(str, 0, n-1, n));
    }
}

/*
=> walk-through: str = "aba", call countSubstrgs(str, 0, 2, 3)

1) n = 3, not a base case. Compute:

    A = countSubstrgs(str, 1, 2, 2) for "ba"

    B = countSubstrgs(str, 0, 1, 2) for "ab"

    C = countSubstrgs(str, 1, 1, 1) for "b"

2) Evaluate A ("ba"):

    n = 2 → A = count(2,2,1) + count(1,1,1) - count(2,1,0)

    count(2,2,1) = 1 ("a"), count(1,1,1) = 1 ("b"), count(2,1,0) = 0

    ends 'b' != 'a' → no +1

    So A = 1 + 1 - 0 = 2 (palindromes: "b", "a")

3) Evaluate B ("ab") — symmetric result 2 (palindromes: "a", "b").

4) Evaluate C ("b") → base case n==1 → 1.

5) Now top-level res = A + B - C = 2 + 2 - 1 = 3. Since str[0] == str[2] ('a' == 'a') add 1 → res = 4.

 */