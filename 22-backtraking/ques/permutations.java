package ques;
import java.util.*;


// leet code 46
class Solution {
    public static void find(List<Integer> nums, int idx, List<List<Integer>> result, List<Integer> currAns) {
        // base case
        if(idx == 0) {
            List<Integer> newList = new ArrayList<>(currAns);
            result.add(newList);
            return;
        }
        // kaam
        for(int i=0;i<nums.size();i++) {
            int currEle = nums.get(i);
            currAns.add(currEle);
            nums.remove(new Integer(currEle));

            find(nums, idx-1, result, currAns);

            nums.add(i, currEle);
            currAns.remove(currAns.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> nums1 = new ArrayList<>();
        for (int x : nums) {
            nums1.add(x);
        }


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();

        find(nums1, nums.length, result, currAns);

        return result;
    }
}