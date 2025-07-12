package Balanced_Binary_tree;

public class Solution {
     public boolean isBalanced(TreeNode root){
        if(root==null) return true; 

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(Math.abs(leftDepth - rightDepth) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
     }
     private int depth(TreeNode node){
        if(node == null)return 0 ;

        return 1+ Math.max(depth(node.left),depth(node.right));
     }
    
}
