package com.github.leetcode.array;

public class CanPlaceFlowers {
    
 public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                i++;
            }else{
                if(flowerbed[i] == 0 
                        && (i == 0 || flowerbed[i - 1] == 0) 
                        && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                    flowerbed[i] = 1;
                    n--;
                    if(n == 0){
                        break;
                    }
                }
                
            }
        }
     
         return n == 0;
    }
}
