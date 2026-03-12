package Longest_Substr_with_Atmost_K_Distinct_Character;
import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int longestSubstring(String s, int k){
        int maxLen = 0;
        int l = 0 , r = 0;
        Map<Character, Integer> mp = new HashMap<>();

        while(r < s.length()){
            if(!mp.containsKey(s.charAt(r))){
                mp.put(s.charAt(r),1);
            }else{
                mp.put(s.charAt(r), mp.get(s.charAt(r)) +1);
            }

            if(mp.size() > k){
                mp.put(s.charAt(l), mp.get(s.charAt(l)) -1);
                if(mp.get(s.charAt(l)) == 0) mp.remove(s.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
            
        }
        return maxLen;
    }

    public static void main(String [] args){
        Solution sol = new Solution();
        String s = "aaabbccd";
        int k = 2;

        int result  = sol.longestSubstring(s,k);
        System.out.println(result);
    }
    
}
