package com.github.leetcode.array;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum. 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], 
 * the contiguous subarray [4,-1,2,1] has the largest
 * sum = 6.
 * 
 * @author wangyu
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            max = Math.max(max, sum);
            
        }
        return max;
    }
    
    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maximumSubarray.maxSubArray(nums);
        System.out.println(max);
    }
}
