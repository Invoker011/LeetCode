package Can_Place_Flower;

public class Solution {
    public boolean canPlaceFlower(int[] flowerbed,int n){
        for(int i = 0; i< flowerbed.length; i++){
            if(flowerbed[i] == 0){
                boolean leftSide = (i == 0 || flowerbed[i-1] == 0);
                boolean rightSide = ( i == flowerbed.length -1 || flowerbed[i+1] == 0);

                if(leftSide && rightSide){
                    n--;
                    i++;
                }
            }
        }
        return n <= 0;
    }
    
}
