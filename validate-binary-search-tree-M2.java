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
    public boolean isValidBST(TreeNode root) {
        Integer l = null, r = null;
        return isValidBSTUtil(root, l, r);
    }
    
    public boolean isValidBSTUtil(TreeNode root, Integer l, Integer r) {
        if(root == null)
            return true;
        
        if((l != null && root.val <= l) || (r != null && root.val >= r))
            return false;
        
        if(isValidBSTUtil(root.left, l, root.val))
            return isValidBSTUtil(root.right, root.val, r);
        return false;
    }
}