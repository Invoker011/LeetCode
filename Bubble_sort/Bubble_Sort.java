package Bubble_sort;

public class Bubble_Sort {
    public static int[] sort(int[] nums){
        int n = nums.length;

        for(int i = n - 1; i >=0; i--){
            boolean swap = false;
            for(int j =0; j <= i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    swap = true;
                }
            }
            if(swap == false){
                break;
            }
        }
        return nums;

    }
    public static void main(String args[]){
        int[] arr = {60, 54,80, 24,89,30};
        int [] ans = Bubble_Sort.sort(arr);

        for(int a : ans){
            System.out.println(a);
        }

    }
    
}
