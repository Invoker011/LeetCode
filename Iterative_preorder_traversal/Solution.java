package Iterative_preorder_traversal;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return result;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        List<Integer> output = sol.preorderTraversal(root);
        System.out.println("Preorder Traversal: " + output);
    }
}
