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
    public boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        isBalancedUtil(root);
        return isBalanced;
    }
    
    public int isBalancedUtil(TreeNode root) {
        if(root == null)
            return 0;
        int lH = isBalancedUtil(root.left);
        int rH = isBalancedUtil(root.right);
        
        if(Math.abs(lH-rH) > 1){
            isBalanced = false;
        }
        return Math.max(lH, rH) + 1; 
    }
}