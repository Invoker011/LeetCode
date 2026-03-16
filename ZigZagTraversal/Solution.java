package ZigZagTraversal;
import java.util.*;
public class Solution {
    public List<List<Integer>> zigZagTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue <TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();

            int[] resultList = new int[size];
            
            for(int i = 0; i<size;i++){
                TreeNode node = q.poll();

                int index = leftToRight ? i: size-1-i;
                resultList[index] = node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            leftToRight = !leftToRight;

            List<Integer> Li = new ArrayList<>();
            for(int l : resultList){
                Li.add(l);
            }
            result.add(Li);
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        Solution sol = new Solution();

        List<List<Integer>> result = sol.zigZagTraversal(root);

        System.out.println(result);
        
    }
    
}
