package com.github.leetcode.array;

/**
 * Given a sorted array and a target value,return the index if the target is 
 * found.if not,return the index where it would be if it were inserted in order.
 * you may assume no duplicates in the array.
 * @author wangyu
 *
 */
public class SearchInsertPosition {
    
    public int serachInsert(int[] nums,int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > target){
                return i;
            }
        }
        return nums.length;
    }
   
    public int serachInsert2(int[] nums,int target){
        int low = 0, high = nums.length;
        while(low<high) {
            int mid=low+(high-low)/2; // low<=mid, mid<high
            //mid = (low + high) / 2 not use reason:if low and high are very big,this line will cause overflow errror…
            if (nums[mid]>=target) {
                high=mid; // high always decreases (even high-low==1)
            }else{
                low=mid+1; // low always increases
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1,3,5,6,8};
        int index = searchInsertPosition.serachInsert2(nums, 6);
        System.out.println(index);
    }

}
