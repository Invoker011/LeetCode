package preorder_transversal_binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
        preorder(root);
        return result;
    }
    private void preorder(TreeNode node){
        if(node == null) return;
        result.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }
}
