package Pow_x_n;

public class Solution {
    public double pow(int x, int n){
        // double ans = 1.0;
        // long nn = n;

        // if(n < 0) nn = -1*nn;

        // while(nn > 0){
        //     if(nn % 2 == 1){
        //         ans *= x;
        //         nn--;
        //     }else{
        //         x *=x;
        //         nn/=2;
        //     }
        // }
        //
        if(n < 0) {
     //       ans = 1.0/ans;
            return 1.0/power(x,n);
        }
       // return ans;
        return power(x,n);
    }

    private double power(double x, long n){
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n % 2 == 0){
            return power(x * x, n/2);
        }
        return x * power(x, n - 1);
    }
    
}
