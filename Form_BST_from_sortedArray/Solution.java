package Form_BST_from_sortedArray;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        return treeBuilder(nums,0,nums.length-1);
    }
    private TreeNode treeBuilder(int[]arr, int left, int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = treeBuilder(arr,left,mid-1);
        root.right = treeBuilder(arr,mid+1,right);
        return root;
    }
    
}
