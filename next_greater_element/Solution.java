package next_greater_element;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int [] ans = new int[nums1.length];
        for(int i =0;i<nums1.length; i++){
            int index =0;
            boolean trigger = false;
            for(int j =0; j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    index = j;
                    trigger = true;
                }
                if(nums1[i]<nums2[j]&&j>index&&trigger){
                    ans[i] = nums2[j];
                    break;
                }
                else{
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
    
}
