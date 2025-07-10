package inorder_traversal_binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer>result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        inorder(root);
        return result;
    }
    private void inorder(TreeNode node){
        if(node==null)return;

        inorder(node.left);
        result.add(node.val);
        inorder(node.right);
    }
    
}
