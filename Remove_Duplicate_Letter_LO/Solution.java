package Remove_Duplicate_Letter_LO;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetter(String s){
        int[] lastSeen = new int[26];
        for(int i = 0; i<s.length(); i++){
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        Stack<Character>st = new Stack<>();
        boolean [] inStack = new boolean[26];

        for(int i = 0; i<s.length(); i++){
            if(inStack[s.charAt(i) - 'a']) continue;

            while(!st.isEmpty() && st.peek() > s.charAt(i) && lastSeen[st.peek() - 'a'] > i){
                inStack[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(s.charAt(i));
            inStack[s.charAt(i)] = true;
        }
        StringBuilder sb = new StringBuilder();

        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
    
}
