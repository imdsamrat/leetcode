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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        int ans = maxPathSumUtil(root);
        return max;
    }
    
    public int maxPathSumUtil(TreeNode root) {
        if(root == null) return 0;
        int leftGain = Math.max(maxPathSumUtil(root.left), 0);
        int rightGain = Math.max(maxPathSumUtil(root.right), 0);
        int totalSum = root.val + leftGain + rightGain;
        max = Math.max(max, totalSum);
        return root.val + Math.max(leftGain, rightGain);
    }
}