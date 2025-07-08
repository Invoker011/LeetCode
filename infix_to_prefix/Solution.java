package infix_to_prefix;

import java.util.*;
public class Solution {
    public String reverseString(String s){
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') sb.append(')');
            else if (c == ')') sb.append('(');
            else sb.append(c);
        }
        return sb.toString();
    }
    public int priority(char c){
        if(c == '^') return 3;
        else if (c=='*' || c =='/') return 2;
        else if (c=='+'|| c=='-') return 1;
        else return -1;
    }
    public String infixToPrefix(String s){
        String rev = reverseString(s);
        String ans = "";
        int i =0;
        Stack <Character> fix = new Stack<>();
        while(i < rev.length()){
            char c = rev.charAt(i);
            if((c >='A' && c <= 'Z') || (c>='0'&& c<='9')|| (c>='a' && c<='z')){
                ans += c;
            }
            else if(c =='('){
                    fix.push(c);
            }
            else if( c == ')'){
                while(!fix.isEmpty() && fix.peek() != '('){
                    ans += fix.pop();
                }
                if (!fix.isEmpty()) fix.pop();
            }
            else{
                // if(c =='^'){
                //     while(!fix.isEmpty() && priority(c) <= priority(c)){
                //         ans += fix.pop();
                //     }
                // }
                while (!fix.isEmpty() && priority(c) < priority(fix.peek())){
                    ans += fix.peek();
                    fix.pop();
                }
                fix.push(c);
            }
            i++;
    }
    while(!fix.isEmpty()){
        ans += fix.pop();
    }
    String newRes = reverseString(ans);
    
    return newRes;
    }
     public static void main(String[] args){
        String s = "(A+B)*C-D+F^E";
        Solution sol = new Solution();
        String result = sol.infixToPrefix(s);
        System.out.println(result);
    }
}
