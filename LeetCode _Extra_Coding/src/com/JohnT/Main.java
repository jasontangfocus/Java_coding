package com.JohnT;

public class Main {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        int target = 3;
        boolean result;
        Solution answer = new Solution();

        System.out.println(nums.length);
        result = answer.search(nums, target);
        System.out.println(result);

    }


}

class Solution {
    public boolean search(int[] nums, int target) {
        //special case
        if (nums == null || nums.length ==0) {
            return false;
        }

        //normal
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            } else {
                continue;
            }
        }

        return false;
    }
}