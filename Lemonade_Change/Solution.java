package Lemonade_Change;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i =0; i < bills.length; i++){
            if(bills[i] == 5) five++;

            else if (bills[i] == 10){
                if(five >=1){
                    ten++;
                    five--;
                }else{
                    return false;
                }
            }

            else{
                if(five >= 1 && ten >=1){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
        
    }
    
}
