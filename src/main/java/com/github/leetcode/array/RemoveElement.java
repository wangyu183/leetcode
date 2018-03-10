package com.github.leetcode.array;

import java.util.Arrays;

public class RemoveElement {
    
    public int removeElement(int[] nums,int val){
        
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    
    public int removeElement2(int[] nums, int val) {
        if(nums==null || nums.length==0) return 0;
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                int tmp = nums[len]; 
                nums[len++] = nums[i]; 
                nums[i] = tmp;
            }
        }
        return len;
    }
    
    public int removeElement3(int[] A, int elem) {
        int l = A.length;
        for (int i=0; i<l; i++) {
            if (A[i] == elem) {
//                A[i--] = A[--l];
                A[i--] = A[l-- - 1];
            } 
        }
        return l;
    }
    
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {3,3,3,2};
        int length = removeElement.removeElement3(nums, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
        
    }
    
}
