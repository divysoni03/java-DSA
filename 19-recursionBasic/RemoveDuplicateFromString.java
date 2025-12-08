// google, microsoft

/* remove duplicate from the string (a-z)*/

// my code
// public class RemoveDuplicateFromString {
//     public static String find(String str) {
//         int count[] = new int[24];
//         StringBuilder output = new StringBuilder();
        
//         for(int i=0;i<str.length();i++) {
//             count[(int)(str.charAt(i)-'a')]++;
//         }
//         for(int i=0;i<str.length();i++) {
//             if(count[(int)(str.charAt(i)-'a')] > 1) {
//                 output.append(str.charAt(i));
//                 count[(int)(str.charAt(i)-'a')] = 0;
//                 continue;
//             } else if (count[(int)(str.charAt(i)-'a')] == 1) {  
//                 output.append(str.charAt(i));
//                 count[(int)(str.charAt(i)-'a')]--;
//             }
//         }
//         return output.toString();
//     }

//     public static void main(String[] args) {
//         System.out.println(find("appnnacollege"));
//     }
// }

// by recursion
public class RemoveDuplicateFromString {
    public static void find(String str, int idx, StringBuilder newStr, boolean map[]) {
       // base case
       if(idx == str.length()) {
           System.out.println(newStr);
           return;
        }    
        char currChar = str.charAt(idx);
        if(map[currChar-'a']) { // duplicate
            find(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            find(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String[] args) {
        find("appnnacollege", 0, new StringBuilder(""), new boolean[26]);
    }
}