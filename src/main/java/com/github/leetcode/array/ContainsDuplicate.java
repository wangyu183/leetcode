package com.github.leetcode.array;

import java.util.Arrays;

public class ContainsDuplicate {
    
    /**
     * 时间复杂度太高 未通过测试 
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == nums[i]){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {3,2,5,5,4};
        ContainsDuplicate array = new ContainsDuplicate();
        System.out.println(array.containsDuplicate2(nums));
    }
}
