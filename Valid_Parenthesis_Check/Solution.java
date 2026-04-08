package Valid_Parenthesis_Check;

import java.util.Stack;

public class Solution {
    public boolean validParenthesis(String s){
        Stack<Integer> opIndex = new Stack<>();
        Stack<Integer> starIndex = new Stack<>();

        for(int i = 0; i< s.length() ;i++){
            char ch = s.charAt(i);
            if( ch == '(') opIndex.push(i);
            else if( ch == '*') starIndex.push(i);
            else{
                if(!opIndex.isEmpty()) opIndex.pop();
                else if(!starIndex.isEmpty()) starIndex.pop();
                else return false;
            }
        }
        while(!opIndex.isEmpty() && !starIndex.isEmpty()){
            if(opIndex.peek() > starIndex.peek()) return false;
            opIndex.pop();
            starIndex.pop(); 
        }
        return opIndex.isEmpty();
    }
    
}
