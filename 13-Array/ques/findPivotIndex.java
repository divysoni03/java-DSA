package ques;

// leet code 724

// my first code
// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int prefix[] = new int[n];

//         // calculate the prefix sum
//         prefix[0] = nums[0];
//         for(int i=1;i<n;i++) {
//             prefix[i] = nums[i] + prefix[i-1];
//         }

//         // fetch the total sum
//         int sum=prefix[n-1], left = 0;
//         for(int i=0;i<n;i++) {
//             sum -= nums[i]; // remove the curr number from the sum
//             // and compare with left curr sum
//             if(sum == left) {
//                 return i;
//             }
//             // if not equal then add that to left sum
//             left += nums[i];
//         }
//         return -1;
//     }
// }

// after some improvement
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int rightSum = 0, leftSum = 0;

        for(int i=0;i<n;i++) {
            rightSum += nums[i];
        }

        // iterate through the array
        for(int i=0;i<n;i++){
            // update the right sum
            rightSum -= nums[i]; // exclude the curr ele from the sum

            if(rightSum == leftSum) return i;

            leftSum += nums[i]; // include curr element in the left sum before moving forward to the next element
        }
        return -1;
    }
}

/*
| Index | Element | Left Sum               | Right Sum              | Left == Right     |
| ----: | ------: | ---------------------- | ---------------------- | ----------------- |
|     0 |       1 | 0                      | 7 + 3 + 6 + 5 + 6 = 27 | ❌                 |
|     1 |       7 | 1                      | 3 + 6 + 5 + 6 = 20     | ❌                 |
|     2 |       3 | 1 + 7 = 8              | 6 + 5 + 6 = 17         | ❌                 |
|     3 |       6 | 1 + 7 + 3 = 11         | 5 + 6 = 11             | ✅ **Pivot Index** |
|     4 |       5 | 1 + 7 + 3 + 6 = 17     | 6 = 6                  | ❌                 |
|     5 |       6 | 1 + 7 + 3 + 6 + 5 = 22 | 0                      | ❌                 |
 */