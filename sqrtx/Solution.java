package sqrtx;

public class Solution {
    public int mySqrt(int x){
        int left = 1;
        int right = x / 2;
        int result =0;;
        if (x<2) return x;

        while(left <= right){
            int mid = left + (right-left)/2;
            int square = mid * mid;

            if(square == x){
                return mid;
            }
            else if(square < x){
                result = mid;
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return result;
    }
}
