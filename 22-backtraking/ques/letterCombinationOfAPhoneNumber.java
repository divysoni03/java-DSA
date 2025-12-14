package ques;

// leet code 17
// https://leetcode.com/problems/letter-combinations-of-a-phone-number?envType=problem-list-v2&envId=backtracking

// class Solution {
//     static HashMap<Character, String> table = new HashMap<>();

//     public static void find(List<String> ans, String digits, StringBuilder combination, int k) {
//         // base case
//         if(digits.length() == k) {
//             ans.add(combination.toString());
//             return;
//         }

//         String currWord = table.get(digits.charAt(k)); // fetch curr word corresponding to the digit from table

//         for(int i=0;i<currWord.length(); i++) {
//             combination.append(currWord.charAt(i)); // add char from currWord
//             find(ans, digits, combination, k+1); // and call for other digitWord
//             // combination = combination.substring(0, combination.length() - 1);
//             combination.deleteCharAt(combination.length()-1); // after adding all the possible words able to make with curr char of Word go to the next char and do the same 
//         }
//     }
//     public List<String> letterCombinations(String digits) {
//         List<String> ans = new ArrayList<>();
//         table.put('2', "abc");
//         table.put('3', "def");
//         table.put('4', "ghi");
//         table.put('5', "jkl");
//         table.put('6', "mno");
//         table.put('7', "pqrs");
//         table.put('8', "tuv");
//         table.put('9', "wxyz");

//         if(digits == null || digits.length() == 0) return ans;
//         find(ans, digits, new StringBuilder(""), 0);
//         return ans;
//     }
// }