package iterative_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
     public List<Integer> inorderTraversal(TreeNode root){
        List<Integer>result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
     }
    
}
