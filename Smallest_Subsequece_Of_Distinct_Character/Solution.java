package Smallest_Subsequece_Of_Distinct_Character;

import java.util.Stack;

public class Solution {
    public String smallestSubsequence(String s) {
        int[] lastSeen = new int[26];
        for(int i = 0; i< s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        Stack<Character>  st = new Stack<>();
        boolean [] inStack = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(inStack[ch - 'a']) continue;

            while(!st.isEmpty() && ch < st.peek() && lastSeen[st.peek() - 'a'] > i){
                inStack[st.peek() - 'a'] = false;
                st.pop();
            }

            st.push(ch);
            inStack[ch -  'a'] = true;

            }
        
        StringBuilder sb = new StringBuilder();

        for (char ch : st){
            sb.append(ch);
        }
        return sb.toString();
        
    }
    
}
