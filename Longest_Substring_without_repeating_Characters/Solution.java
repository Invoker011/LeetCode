package Longest_Substring_without_repeating_Characters;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int longestSubString(String s){
        int answer = 0;
        int left = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char ch  = s.charAt(right);
            if(mp.containsKey(ch)){
                left = Math.max(left, mp.get(ch)+1);
            }
            mp.put(ch, right);
            answer = Math.max(answer, right - left +1);         
        }
        return answer;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String que ="bbbbb";
        int result = sol.longestSubString(que);
        System.out.println(result);
    }
}
