package Max_depth_of_tree;

public class Solution {
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int left= maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }
    
}
