package Merge_sort;

public class Merge_Sort {

    public static void merge(int[] arr, int low, int mid,  int high ){
        int[] temp = new int[arr.length];
        int left = low;
        int right = mid + 1;
        int i =0;
        
        while(left <= mid && right <=high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                i++;
                left++;
            }else{
                temp[i] = arr[right];
                i++;
                right++;
            }
        }
        while(left <= mid){
            temp[i] = arr[left];
            left++;
            i++;
        }
        while(right <= high){
            temp[i] = arr[right];
            right++;
            i++;
        }

        for(int j = low; j<=high; j++){
            arr[j] = temp[j - low];
        }
    }

    public static void mergesort(int[] arr, int low, int high){
        if(low >= high) return;
        int mid = (low + high) /2;

        mergesort(arr, low, mid);
        mergesort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }


    public static void sort(int[]nums){
        mergesort(nums,0,nums.length-1);
    }

    public static void main(String [] args){
        int[] arr = {98,56,43,101,45,3,36};
        Merge_Sort.sort(arr);

        for(int a : arr){
            System.out.println(a);
        }
    }
    
}
