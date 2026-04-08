package Minimum_Window_Subsequence;

public class Solution {
    public String minWindowSequence(String s, String b){
        int r = 0;
        int l = 0;
        int p = 0;
        int minSub = s.length() + 1;
        int startingIndex = -1;
        int endingIndex = -1;

        while(r < s.length()){
            if(s.charAt(r) == b.charAt(p)){
                p++;
                if(p == b.length()){
                    p--;
                    l=r;
                    while(l>=0 && p >= 0){
                        if(s.charAt(l) == b.charAt(p)){
                            p--;
                        }
                        if(p == -1){
                            if(r-l+1 < minSub){
                                minSub = r - l + 1;
                                startingIndex  = l;
                                endingIndex = r;
                            }
                        }
                        l--;
                    }
                    p=0;    
                }
            }
            r++;
        }
        return startingIndex == -1 ?"":s.substring(startingIndex, endingIndex + 1);
    }
}
