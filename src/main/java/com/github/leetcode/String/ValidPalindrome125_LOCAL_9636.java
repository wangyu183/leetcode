package com.github.leetcode.String;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.
    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.
    For the purpose of this problem, we define empty string as valid palindrome.
 * @author wangyu
 *
 */
public class ValidPalindrome125 {
    
    public boolean isPalindrome(String s){
        for(int i = 0,j = s.length() - 1; i < s.length() && j >=0; ){
            Character begin = s.charAt(i);
            Character end = s.charAt(j);
            boolean beginFlag = Character.isDigit(begin) || Character.isLetter(begin);
            boolean endFlag = Character.isDigit(end) || Character.isLetter(end);
            if(beginFlag && endFlag){
                if(Character.toUpperCase(begin) == Character.toUpperCase(end)){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }else if(beginFlag && !endFlag){
                j--;
            }else if(!beginFlag && endFlag){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        ValidPalindrome125 test = new ValidPalindrome125();
        String s = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = ".,";
        boolean result = test.isPalindrome(s3);
        System.out.println(result + "" + "");
    }
    
}
