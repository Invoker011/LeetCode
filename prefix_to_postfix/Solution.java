package prefix_to_postfix;

import java.util.Stack;

public class Solution {
        public String prefixToPostfix( String s){
        Stack <String> fix = new Stack<>();
        int i=s.length()-1;
        while(i>=0){
            char c = s.charAt(i);
            if((c >='A'&& c <='Z')||(c >='0'&&c<='9')||(c>='a'&&c<='z')){
                fix.push(String.valueOf(c));
            }
            else{
                String left = fix.pop();
                String right = fix.pop();
                String newString = left+right+c;
                fix.push(newString);
            }
            i--;
        }
        return fix.peek();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String str = "/-AB*+DEF";
        String result = sol.prefixToPostfix(str);   
        System.out.println(result);
    }
    
}
