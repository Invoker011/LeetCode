package Delete_And_Earn;

public class Solution {
    public int deleteAndEarn(int[] nums){
        int maxNumber = 0;
        for(int num : nums){
            maxNumber = Math.max(maxNumber, num);
        }
        int[] points = new int[maxNumber + 1];
        for(int num:nums){
            points[num] += num;
        }
        int prevprev = 0;
        int prev = 0;

        for(int i = 0; i < maxNumber; i++){
            int takePoints = prevprev + points[i];
            int skipPoints = prev;

            int current = Math.max(takePoints, skipPoints);

            prevprev= prev;
            prev = current;
        }
        return prev;
    }
}
