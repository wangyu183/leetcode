package com.github.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * 时间复杂度太高 未通过测试
     * 
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * time complexity:O(N lg N) why?
     * 
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * we can userd a well known data structure hash table that will help us to
     * identify whether an element has been previously encountered in the array
     * 
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    /**
     * we can use the new stream in JDK8
     * @param nums
     * @return
     */
    public boolean containsDuplicate4(int[] nums) {
        int length = (int) Arrays.stream(nums).distinct().count();
        return nums.length != length;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 5, 5, 4 };
        ContainsDuplicate array = new ContainsDuplicate();
        System.out.println(array.containsDuplicate2(nums));
    }
}
