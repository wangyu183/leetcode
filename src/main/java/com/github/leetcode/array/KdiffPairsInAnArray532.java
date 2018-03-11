package com.github.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wangyu
 *
 */
public class KdiffPairsInAnArray532 {
    
    /**
     * we use hashmap to count every num in nums, 
     * if the sum that key add k exists, output++.  
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0){
            return 0;
        }
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(16);
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(k == 0){
                //count how many elements in the array that appear more than twice.
                if(entry.getValue() >= 2){
                    count++;
                }
            }
            if(map.containsKey(entry.getKey() + k)){
               count++; 
            }
        }
        return count;
     }
    
    
    public int findPairs2(int[] nums,int k){
        if(k < 0 || nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0,j = 1; j < nums.length;){
            if(j <= i || nums[i] + k > nums[j]){
                j++;
            }else if(i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]){
                i++;
            }else{
                count++;
                i++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        KdiffPairsInAnArray532 array = new KdiffPairsInAnArray532();;
        int[] nums = {1,2,1,5,4};
        int count = array.findPairs2(nums, 0);
        System.out.println(count);
    }
}
