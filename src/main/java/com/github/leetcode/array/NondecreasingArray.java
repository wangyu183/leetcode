package com.github.leetcode.array;

/**
 * Given an array with n integers, your task is to check if it could become
 * non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for
 * every i (1 <= i < n).
 * 
 * Example 1: Input: [4,2,3] Output: True Explanation: You could modify the
 * first 4 to 1 to get a non-decreasing array.
 * 
 * @author wangyu
 *
 */
public class NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int len = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] < nums[i - 1]) {
                len++;
                if(i - 2 >= 0 && nums[i] < nums[i - 2]){
                    nums[i] = nums[i-1];
                }else{
                    nums[i - 1] = nums[i];
                }
            }
        }
        return len <= 1;
    }

    public static void main(String[] args) {
        NondecreasingArray array = new NondecreasingArray();
        int[] nums = {3, 4, 2, 3 };
        boolean flag = array.checkPossibility(nums);
        System.out.println(flag);
    }

}
