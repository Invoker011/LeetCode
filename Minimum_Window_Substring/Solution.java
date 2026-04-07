package Minimum_Window_Substring;

public class Solution {
    public String minWindow(String s, String t){
        int l = 0;
        int r = 0;
        int count = 0;
        int startingIndex = -1;
        int minWindow = Integer.MAX_VALUE;
        int [] hash = new int[256];

        for(int i = 0; i < t.length(); i++){
            hash[t.charAt(i)]++;
        }

        while(r < s.length()){
            if(hash[s.charAt(r)] > 0){
                count++;
                hash[s.charAt(r)]--;
            }else{
                hash[s.charAt(r)]--;
            }

            while(count == t.length()){
                if(r - l + 1 <  minWindow){
                    minWindow = r - l + 1;
                    startingIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
        }
        return startingIndex == -1 ? "" : s.substring(startingIndex, startingIndex+minWindow);
    }
}
