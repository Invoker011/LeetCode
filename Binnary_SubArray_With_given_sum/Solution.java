package Binnary_SubArray_With_given_sum;

public class Solution {
    public int maxNumberOfSubarrays(int[] nums, int goal){
        return numberOfSubarrays(nums, goal) - numberOfSubarrays(nums, goal-1);
    }

    private int numberOfSubarrays(int[] nums,  int goal){
        int l =0,  r = 0,   arrCnt = 0,  sum =0;

        if(goal < 0) return 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum >goal){
                sum -= nums[l];
                l++;
            }

            arrCnt += (r-l+1);
            r++;
        }
        return arrCnt;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] que = {0,0,0,0,0};

        int goal = 0;

        int result = sol.maxNumberOfSubarrays(que, goal);

        System.out.println(result);

    }
    
}
