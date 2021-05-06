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
    Integer ans;
    public int maxPathSum(TreeNode root) {
        ans = root.val;
        maxPathSumUtil(root);
        return ans;
    }
    public int maxPathSumUtil(TreeNode root) {
        if(root == null) return 0;
        int leftGain = Math.max(maxPathSumUtil(root.left), 0);
        int rightGain = Math.max(maxPathSumUtil(root.right), 0);
        ans = Math.max(ans, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}