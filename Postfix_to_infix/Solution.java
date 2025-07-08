package Postfix_to_infix;
import java.util.*;

public class Solution {
    public String postfixToInfix(String s){
        Stack<String> fix = new Stack<>();
        int i =0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if((ch >= 'A' && ch <='Z')||(ch >='0' && ch<='9') || (ch >= 'a'&& ch<='z')){
                fix.push(String.valueOf(ch));
            }
            else{
                String right = fix.pop();
                String left = fix.pop();
                String newString = "(" + left +ch+right+")";
                fix.push(newString);
            }
            i++;
        }
        return fix.peek();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String str = "AB-DE+F*/";
        String result = sol.postfixToInfix(str);
        System.out.println(result);
    }
}
