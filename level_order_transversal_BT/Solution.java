package level_order_transversal_BT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
     public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i =0; i<n;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right != null)queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
     }
    
}
