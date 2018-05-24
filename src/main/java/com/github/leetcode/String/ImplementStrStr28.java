package com.github.leetcode.String;

public class ImplementStrStr28 {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack == ""){
            return -1;
        }
        return haystack.indexOf(needle);
    }
     
    public int strStr2(String haystack, String needle) {
        if(haystack == null || haystack == ""){
            return -1;
        }
        return haystack.indexOf(needle);
    }
    
    public static void main(String[] args) {
        
    }
}
