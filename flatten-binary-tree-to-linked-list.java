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
    public void flatten(TreeNode root) {
        flattenUtil(root);
    }
    
    TreeNode currNode = null;
    public TreeNode flattenUtil(TreeNode root) {
        if(root == null)
            return null;
        currNode = root;
        TreeNode right = root.right;
        root.right = flattenUtil(root.left);
        root.left = null;
        currNode.right = flattenUtil(right);
        return root;
    }
}