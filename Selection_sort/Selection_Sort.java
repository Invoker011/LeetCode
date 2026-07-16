package Selection_sort;

public class Selection_Sort{
    public static int[] sort(int[] nums){
        int n = nums.length;

        for(int i = 0; i <= n-2; i++){
            int min = i;
            for(int j = i; j<= n-1; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args){
        int[] arr = {23,45,24,50,67,43};
        int[] ans = Selection_Sort.sort(arr);
        for(int a : ans){
            System.out.println(a);
        }

    }
}