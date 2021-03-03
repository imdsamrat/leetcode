/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        getLeafNode(root1, l1);
        List<Integer> l2 = new LinkedList<>();
        getLeafNode(root2, l2);
        
        return isEqual(l1, l2);
    }
    
    public void getLeafNode(TreeNode root, List<Integer> l) {
        if(root == null)
            return;
        getLeafNode(root.left, l);
        if(root.left == null && root.right == null){
            l.add(root.val);
            return;
        }
        
        getLeafNode(root.right, l);
    }
    
    public boolean isEqual(List<Integer> l1, List<Integer> l2) {
        int i = 0, j = 0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i++) != l2.get(j++))
                return false;
        }
        if(i<l1.size() || j<l2.size())
            return false;
        return true;
    }
}