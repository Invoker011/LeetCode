import java.util.Stack;

class Solution{
    public boolean isValid(String s){
    //     Stack <Character> parenthesis = new Stack<>();
    //     for(int i =  0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch == '(' || ch == '[' || ch == '{'){
    //             parenthesis.push(ch);
    //         }
    //         else if(parenthesis.isEmpty() && (ch ==')'||ch==']'||ch=='}')) return false;

    //         else if(!parenthesis.isEmpty()){
    //             char par = parenthesis.pop();
    //             if((ch == ')' && par != '(') || (ch == ']' && par !='[') || (ch == '}' && par !='{')) return false;
    //         }
    //     }
    //     return parenthesis.isEmpty();

    //Optimised Using Array instead of stack
        int n = s.length();
        if(n%2!=0) return false;
        char[] parenthesis = new char[n];
        int i =0;
        for( char c : s.toCharArray()){
            if(c == '(') parenthesis[i++] = ')';
            else if(c == '[') parenthesis[i++] = ']';
            else if(c == '{') parenthesis[i++] = '}';
            else{
                if(i == 0 || c != parenthesis[i-1]) return false;
                i-=1;
            }
        }
        return i ==0;
    }

}