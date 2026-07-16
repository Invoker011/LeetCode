package Insertion_sort;

public class Insertion_sort {
    public static int[] sort(int [] nums){
        int n = nums.length;

        for(int i =0; i <= n-1; i++){
            int j = i;
            while (j > 0 && nums[j] < nums[j-1]) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args){
        int[] arr = {30,40,70,34,50,22,1};

        int [] ans = Insertion_sort.sort(arr);

        for(int a : ans){
            System.out.println(a);
        }
    }
    
}
