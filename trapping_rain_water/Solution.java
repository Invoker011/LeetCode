package trapping_rain_water;

public class Solution {
    public int trap(int[] height){
        int trapped = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax=0 ;
        int rightMax =0;

        while(left<=right){
            if(height[left] <= height[right]){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }else{
                    trapped += leftMax-height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    trapped += rightMax - height[right];
                }
                right--;
            }
        }
        return trapped;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int [] height = {4,2,0,3,2,5};
        int result = sol.trap(height);
        System.out.println(result);
    }
}
