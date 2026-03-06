package Max_Consecutive_ones_III;

public class Solution {
    public int maxConsecutiveOnes(int [] nums, int k ){
        int maxLen =0, l=0,r=0,zeroCount=0;

        while(r < nums.length){
            if(nums[r] == 1){
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
            else if(nums[r] == 0){
                zeroCount++;
                if(zeroCount <= k){
                    maxLen = Math.max(maxLen, r - l +1);
                    r++;
                }else{
                    while(zeroCount != k){
                        if(nums[l]==0){
                            l++;
                            zeroCount--;
                            r++;
                        }else{
                            l++;
                        }
                       
                    }
                }
            }
        }
        return maxLen;
    }
    class Solution2 {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int l = 0, r = 0;
        int zeroCount = 0;

        while(r < nums.length){
            if(nums[r] == 0) zeroCount++;
            if(zeroCount > k){
                if(nums[l] == 0) zeroCount--;
                l++;
            }
            if(zeroCount <= k) maxLen = Math.max(maxLen, r -l +1);
            r++;
        }
        return maxLen;
    }
}

    public static void main(String[] args){
        Solution sol =  new Solution();
        int [] que = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int atMax = 3;
        int result = sol.maxConsecutiveOnes(que,atMax);

        System.out.println(result);
    }
    
}
