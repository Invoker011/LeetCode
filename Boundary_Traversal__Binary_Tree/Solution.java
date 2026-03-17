package Boundary_Traversal__Binary_Tree;
import java.util.*;
public class Solution {
    public List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        if(!isLeaf(root)){
            result.add(root.val);
        }
        addLeftBoundary(root, result);
        addLeafNodes(root, result);
        addRightBoundary(root, result);




        return result;
    }

    private boolean isLeaf(TreeNode node){
        if(node.right == null && node.left == null) return true;
        return false;
    }
    private void  addLeftBoundary(TreeNode node, List<Integer> res){
        TreeNode curr = node.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.val);
            }
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    private void addLeafNodes(TreeNode node, List<Integer> res){
        if(isLeaf(node)){
            res.add(node.val);
        }
        if(node.left!=null) addLeafNodes(node.left,res);
        if(node.right!=null) addLeafNodes(node.right,res);
    }
    private void addRightBoundary(TreeNode node, List<Integer> res){
        TreeNode curr = node.right;
        List<Integer> leafNode = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)){
                leafNode.add(curr.val);
            }

            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = leafNode.size() -1; i >=0; i--){
            res.add(leafNode.get(i));
        }

    }
     public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();

        // Get the boundary traversal
        List<Integer> result = solution.boundaryTraversal(root);
        for(int r : result){
            System.out.println(r);
        }
        
    }
    
}
