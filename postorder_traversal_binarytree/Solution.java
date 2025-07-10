package postorder_traversal_binarytree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result= new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root){
        postorder(root);
        return result;
    }
    private void postorder(TreeNode node){
        if(node==null) return;

        postorder(node.left);
        postorder(node.right);
        result.add(node.val);
    }
}
