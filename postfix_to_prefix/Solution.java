package postfix_to_prefix;
import java.util.Stack;
public class Solution {
    public String postfixToPrefix( String s){
        Stack <String> fix = new Stack<>();
        int i=0;
        while(i< s.length()){
            char c = s.charAt(i);
            if((c >='A'&& c <='Z')||(c >='0'&&c<='9')||(c>='a'&&c<='z')){
                fix.push(String.valueOf(c));
            }
            else{
                String right = fix.pop();
                String left = fix.pop();
                String newString = c+left+right;
                fix.push(newString);
            }
            i++;
        }
        return fix.peek();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        String str = "AB-DE+F*/";
        String result = sol.postfixToPrefix(str);   
        System.out.println(result);
    }
}
