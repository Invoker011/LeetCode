package plus_one;

public class Solution {
    public int[] plusOne(int[] digits){
        int pointer = digits.length-1;
        int carry = 1;
        while(pointer >=0){
            int sum = digits[pointer] + carry;
            if(sum < 10){
                digits[pointer] = sum;
                carry =0;
            }else{
                digits[pointer] = 0;
                carry =1;
            }
            pointer--;
        }
        if(carry == 0) return digits;
        else{
            int[] newDigits = new int[digits.length+1];
            newDigits[0] =1;
            return newDigits;
        }
    }
}
