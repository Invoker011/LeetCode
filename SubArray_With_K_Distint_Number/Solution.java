import java.util.*;

public class Solution {
    public int subArrayWithkDistinct(int[] nums, int k){
        return countSubArrays(nums,k) - countSubArrays(nums, k-1); //take abs to be safe
        //two ways to solve, Algo is same time complexity theoritically same but in real while loop approach
        // which appraoch 2 is considered standard and take 49 sm to run a set of testcases while approach 1 take 56 ms to run same set of tests.
    }
    //Approach 1: //using if conditions
    private int countSubArrays(int[] num, int i){
        int l = 0;
        int r = 0;
        int arrayCounter = 0;
        boolean addR = true;
        Map<Integer, Integer> mp = new HashMap<>();
        while(r < num.length && l < num.length){
            if(addR){
                mp.put(num[r], mp.getOrDefault(num[r],0) +1);
            }

            if(mp.size() > i){
                mp.put(num[l], mp.get(num[l]) - 1);
                if(mp.get(num[l])==0) mp.remove(num[l]);
                l++;
                addR = false;
            }

            else if(mp.size() <= i){
                arrayCounter +=  (r-l+1);
                r++;
            }
        }
        return arrayCounter;
    }

    //Approach 2: //using while loop;
    private int countSubArrays_withloop(int[] num, int i){
        int l = 0;
        int r = 0;
        int arrayCounter = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(r < num.length && l < num.length){

            mp.put(num[r], mp.getOrDefault(num[r],0) +1);

            while(mp.size() > i){
                mp.put(num[l], mp.get(num[l]) - 1);
                if(mp.get(num[l])==0) mp.remove(num[l]);
                l++;
            }

            arrayCounter +=  (r-l+1);
            r++;

        }
        return arrayCounter;
    }

    
}
