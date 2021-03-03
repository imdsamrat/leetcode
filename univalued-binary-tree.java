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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return true;
        return isUnivalTreeUtil(root.left, root.val) && isUnivalTreeUtil(root.right, root.val);
    }
    
    public boolean isUnivalTreeUtil(TreeNode root, int val) {
        if(root == null)
            return true;
        if(root.val != val)
            return false;
        return isUnivalTreeUtil(root.left, val) && isUnivalTreeUtil(root.right, val);
    }
}