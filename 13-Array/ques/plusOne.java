package ques;

// leet code 66

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i>=0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0; // make curr digit zero if 9 and move forward
            } else {
                // if it's not 9 then add one and return
                digits[i]++;
                return digits;
            }
        }
        // if all are 9 then we have to add one size 
        digits = new int[digits.length + 1]; // if 9 9 9 then it will make 0 0 0 0 array
        digits[0] = 1;
        return digits;
    }
}