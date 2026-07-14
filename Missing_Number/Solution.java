package Missing_Number;

public class Solution {
    public int missingNumber(int[] nums){
        int  xor_1 = 0;
        int  xor_2 =  0;

         for(int i = 0; i < nums.length; i++){
            xor_1^=nums[i];
            xor_2^=(i+1);
         }
         return xor_1^xor_2;
    }
    
}
