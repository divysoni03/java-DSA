package ques;

// leet code 53
/* you can Use brute force but it's time taking, so you can use kadane's algo for this it's simple, but after that there is one problem left
- one case where all element of the array is negative so for tip `focus on finding biggest one among them`, you will eventually get it.
eg., [-2,-1,-2,-3] = biggest sum or element = -1 */

class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE; // starting from very min value
        if(nums.length == 1) return nums[0];
        for(int i:nums) {
            currentSum += i;
            maxSum = Math.max(maxSum, currentSum);
            /** making the currSum 0 after storing the max negative value in the max sum if
             * there are all negative values 
             * - if all negative occurs then we will only select max among them with this algo
             * 
             * - making currSum 0 after 'Math.max(maxSum, currentSum);' wont't change anything for normal 
             * cases if max > currSum where if curr sum is negative then max wont't change
             * 
             * -> [-2,-1,-2,-3] = biggest sum or element = -1
             */
            if(currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }
}