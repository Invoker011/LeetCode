package String_To_Integer;

public class Solution {
    public int myAtoi(String s){
        int i = 0;
        int n = s.length();
        if(s.length() == 0) return 0;
        while(i < n && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < n && (s.charAt(i)=='+' && s.charAt(i)=='-')){
            if(s.charAt(i)=='-'){
                sign = -1;
            }
            i++;
        }

        return helper(s,i,0,sign);
        // int result = 0;
        // while(i<n && Character.isDigit(s.charAt(i))){
        //     int digit = s.charAt(i) - '0';

        //     if(result > (Integer.MAX_VALUE - digit)/10){
        //         return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //     }

        //     result = result * 10 + digit;
        //     i++;
        // }
        // return result * sign;   
    }

    private int helper(String s, int i, int result, int sign){
        if(i >= s.length() && Character.isDigit(s.charAt(i))){
            return result * sign;
        }
        int digit = s.charAt(i) - '0';

        if(result > (Integer.MAX_VALUE - digit)/10){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return helper(s,i+1,result*10+digit,sign);
    }
    
}
