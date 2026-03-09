package Longest_Repeating_Character_Replacement;

public class Solution {
    public int longestString(String s, int k){
        int l =0, r = 0 , maxLen = 0 , maxFreq  = 0;
        int [] freq = new int[26];

        while(r < s.length()){
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            if(r - l +1 - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }else{
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    

    public static void main(String[] args){
        Solution sol =  new Solution();
        String que = "AABABBA";
        int z = 1;

        int result = sol.longestString(que, z);

        System.out.println(result);
    }
}
