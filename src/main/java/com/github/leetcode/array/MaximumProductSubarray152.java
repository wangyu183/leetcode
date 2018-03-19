package com.github.leetcode.array;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i],nums[i]);
            min = Math.min(min * nums[i],nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
    
    public static void main(String[] args) {
        MaximumProductSubarray152 test = new MaximumProductSubarray152();
        int[] nums = {-2,0,-1};
        int max = test.maxProduct(nums);
        System.out.println(max);
    }
}
