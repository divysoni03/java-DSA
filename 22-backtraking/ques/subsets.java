package ques;

// leet code 78
// class Solution {
//     public static void find(List<List<Integer>> result, int[] digits, int i, List<Integer> list) {
//         // base case
//         if(i == digits.length) {
//             // result.add(list); // this will store the reference of the list and when we remove element from the list then element from the result also will be removed so make a new object for storing the data
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         // work (recursion)
//         // case 1 not choosing the curr number 
//         find(result, digits, i+1, list);

//         // case 2 choosing the curr number 
//         list.add(digits[i]);
//         find(result, digits, i+1, list);
//         list.remove(list.size() -1);

//     }
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();

//         List<Integer> list = new ArrayList<>();

//         find(result, nums, 0, list);
//         return result;
//     }
// }

// can also be done with bit manipulation 
