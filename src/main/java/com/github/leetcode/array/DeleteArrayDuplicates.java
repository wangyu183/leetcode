package com.github.leetcode.array;

import java.util.Arrays;

/**
 * 删除排序数组中的重复数字 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 
 * @author wangyu
 *
 */
public class DeleteArrayDuplicates {

    public int removeDuplicates(int[] nums) {

        int num = 0;
        // nums [1,1,2]
        for (int i = 0; i < nums.length; i++) {
            if (nums[num] != nums[i]) {
                nums[++num] = nums[i];
            }
        }
        return ++num;
    }
    
    public int removeDuplicates2(int[] A) {  
        if(A == null || A.length==0)  
            return 0;  
        int index = 1;  
        for(int i=1;i<A.length;i++)  
        {  
            if(A[i]!=A[i-1])  
            {  
                A[index]=A[i];  
                index++;  
            }  
        }  
        return index;  
    }  
    
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,5,5,6,7,8};
        DeleteArrayDuplicates array = new DeleteArrayDuplicates();
        int length = array.removeDuplicates2(nums);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }
}
