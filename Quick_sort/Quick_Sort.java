package Quick_sort;

public class Quick_Sort{
    public static int getPivot(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(arr[i] <= pivot && i <= high){
                i++;
            }
            while(arr[j] >= pivot && j >= low){
                j--;
            }
            if(i < j){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }
    public static void quicksort(int[] nums, int low, int high){
        if(low < high){
            int partitionIndex = getPivot(nums, low, high);
            quicksort(nums, low, partitionIndex -1);
            quicksort(nums,partitionIndex+1,high);
        }
    }

    public static void main(String[] args){
        int[] nums = {40,30,56,34,90,32,76,24,99,85};
        Quick_Sort.quicksort(nums,0,nums.length -1);

        for(int a : nums){
            System.out.println(a);
        }
    }
}