package maximum_path_sum;

public class Solution {
    public int maxPathSum(TreeNode root){
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        pathSumMax(root,maxSum);
        return maxSum[0];
    }
    private int pathSumMax(TreeNode node, int[] maxSum){
        if(node == null)  return 0;

        int leftSum = Math.max(0,pathSumMax(node.left, maxSum));
        int rightSum = Math.max(0,pathSumMax(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0],leftSum+rightSum+node.val);
        return Math.max(leftSum,rightSum)+ node.val;
    }
    
}
