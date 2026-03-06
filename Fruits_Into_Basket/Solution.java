package Fruits_Into_Basket;
import java.util.*;
public class Solution {
    public int maxFruit(int [] fruits){
        int maxLen = 0 , l = 0 , r = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(r < fruits.length){
            if(!mp.containsKey(fruits[r])) {mp.put(fruits[r],1);}
            else {mp.put(fruits[r], mp.get(fruits[r])+1);}
            if(mp.size() > 2){
                mp.put(fruits[l], mp.get(fruits[l]) - 1);
                if(mp.get(fruits[l])==0) mp.remove(fruits[l]);
                l++;
            }
            if(mp.size() <= 2) maxLen = Math.max(maxLen, r - l +1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int [] que = {0,1,2,2};

        int result = sol.maxFruit(que);
        System.out.println(result);
    }
}

   
