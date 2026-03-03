package Kth_Smallest_Element_in_a_Sorted_Matrix;

public class Solution{
    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        int mid;

        while(low < high){
            mid = low + (high-low)/2;
            int count = countLessorEquals(matrix , mid);
            
            if(count < k) low = mid+1;
            else high = mid;
        }
        return low;
    }

    private int countLessorEquals(int [][] matrix, int mid){
        int n = matrix.length;
        int r = n-1;
        int c = 0;
        int count = 0;
        while( r >= 0 && c < n){
            if(matrix[r][c] <= mid){
                count += (r + 1);
                c++;
            }else{
                r--;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };

        int k = 8;

        Solution sol = new Solution();
        int result = sol.kthSmallest(matrix, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}