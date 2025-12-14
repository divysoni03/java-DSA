public class findSubset {
    // my code
    // public static void find (String str, String substr, int i, ArrayList<String> ans) {
    //     if(i == str.length()) {
    //         ans.add(substr); // add final subString to list
    //         return;
    //     }

    //     // curr char want to be added
    //     find(str, substr+str.charAt(i), i+1, ans);

    //     // curr char don't want to be added
    //     find(str, substr, i+1, ans);
    // }

    // apn clg code
    // public static void find (String str, String substr, int i) {
    //     if(i == str.length()) {
    //         if(substr.length() == 0) {
    //             System.out.println("null");
    //         } else {
    //             System.out.println(substr);
    //         }
    //         return;
    //     }

    //     // says yes
    //     find(str, substr+str.charAt(i), i+1);

    //     // says no
    //     find(str, substr, i+1);
    // }

    // with string builder
    public static void find(String str, StringBuilder subStr, int i) {
        if(i == str.length()) {
            if(subStr.length() == 0) {
                System.out.println("null");
            }
            else {
                System.out.println(subStr);
            }
            return;
        }

        // yes
        find(str, subStr.append(str.charAt(i)), i+1);

        // before backtracking after completing all 'yes' calls remove char from the stringBuilder
        subStr.deleteCharAt(subStr.length() - 1); // remove using length not i (both are diff)

        // no
        find(str, subStr, i+1);
    }

    public static void main(String[] args) {
        find("abc", new StringBuilder(""), 0);
    }
}

/* output :

abc
ab
ac
a
bc
b
c
null

*/