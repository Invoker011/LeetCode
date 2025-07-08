import java.util.*;
public class Solution {
    public int priority( char ch){
        if(ch == '^') return 3;
        else if(ch == '*' || ch=='/') return 2;
        else if(ch =='+' || ch =='-') return 1;
        else return -1;
    }
    public String infixtoPostfix(String s){
        String ans = "";
        int i =0;
        Stack<Character> fix = new Stack<>();
        while(i < s.length()){
            char c = s.charAt(i);
            if((c >='A' && c <= 'Z')||(c>=0 && c<=9)|| (c >='a' && c<='z')){
                ans +=c;
            }
            else if(c =='('){
                fix.push(c);
            }
            else if(c ==')'){
                while(!fix.isEmpty() && fix.peek() !='(' ){
                    ans += fix.peek();
                    fix.pop();
                }
                if (!fix.isEmpty()) fix.pop();
            }
            else {
                while (!fix.isEmpty() && priority(c) <= priority(fix.peek())){
                    ans += fix.peek();
                    fix.pop();
                }
                fix.push(c);
            }
            i++;
        }
        while(!fix.isEmpty()){
            ans += fix.peek();
            fix.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "a+b+c*d*(a-e)/c";
        Solution sol = new Solution();
        String result = sol.infixtoPostfix(s);
        System.out.println(result);
    }
}
