package Jump_Game;

public class Solution {
    public boolean canJump(int[] nums){
        int maxTo = 0;
        for(int i =0; i<nums.length; i++){
            if(i > maxTo && nums.length > 0) return false;
            maxTo = Math.max(maxTo, i + nums[i]);
        }
        return true;
    }
    
}
