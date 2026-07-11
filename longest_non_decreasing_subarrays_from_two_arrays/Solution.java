package longest_non_decreasing_subarrays_from_two_arrays;

public class Solution {
    public int longestSubArray(int[] nums1, int[] nums2){
        int n = nums1.length;
        int dp1 = 1;
        int dp2 = 1;
        int MaxLength= 1;

        for(int i = 1; i< n ; i++){
            int currDp1 = 1;
            int currDp2 = 1;

            if(nums1[i] >= nums1[i-1]){
                currDp1 = Math.max(currDp1, dp1 +1);
            }
            if(nums1[i] >= nums2[i-1]){
                currDp1 = Math.max(currDp1, dp2 + 1);
            }
            if(nums2[i] >= nums1[i-1]){
                currDp2 = Math.max(currDp2, dp1 + 1);
            }
            if(nums2[i] >= nums2[i-1]){
                currDp2 = Math.max(currDp2,dp2 + 1);
            }

            dp1 = currDp1;
            dp2 = currDp2;

            MaxLength = Math.max(MaxLength, Math.max(dp1,dp2));
        }
        return MaxLength;
    }
}
