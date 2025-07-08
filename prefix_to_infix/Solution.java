package prefix_to_infix;
import java.util.Stack;
public class Solution {
    public String prefixToInfix(String s){
        Stack <String> fix = new Stack<>();
        int i = s.length() -1;
        while(i >=0){
            char ch = s.charAt(i);
            if((ch >='A'&&ch<='Z')||(ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')){
                fix.push(String.valueOf(ch));
            }
            else{
                String left = fix.pop();
                String right = fix.pop();
                String newString = "(" + left+ ch+right+")";
                fix.push(newString);
            }
            i--;
        }
        return fix.pop();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String str = "*+PQ-MN";
        String result = sol.prefixToInfix(str);
        System.out.println(result);
    }
}
