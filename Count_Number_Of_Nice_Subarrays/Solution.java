package Count_Number_Of_Nice_Subarrays;

public class Solution {
    public int NumberOfSubArrays(int[] nums, int k){
        return numberOfsunArr(nums,k) - numberOfsunArr(nums, k-1);
    }
    private int numberOfsunArr(int[] nums,  int k ){
        int r = 0,  l = 0, arrCnt = 0, sum = 0;

        if(k < 0) return 0;

        while(r < nums.length){
            if(nums[r] % 2 == 1)  sum+=1;
            else  sum+=0;

            while(sum > k){
                if(nums[l] % 2 ==1) sum-=1;
                else sum -=0;
                l++;
            }
            arrCnt += (r-l+1);
            r++;

        }
        return arrCnt;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] que = {2,2,2,1,2,2,1,2,2,2};
        int k  =2;

        int result = sol.NumberOfSubArrays(que, k);
        System.out.println(result);
    }
    
}
