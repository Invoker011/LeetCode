package is_Same_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q){
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        preOrder(p,one);
        preOrder(q,two);
        return one.equals(two);
    }
    private void preOrder(TreeNode node, List<Integer>arr){
        if(node == null){
            arr.add(null);
            return;
        }
        arr.add(node.val);
        preOrder(node.left, arr);
        preOrder(node.right,arr);
    }
    
}
