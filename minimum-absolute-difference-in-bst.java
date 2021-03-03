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
    public int ans = Integer.MAX_VALUE;
    public static int prev;
    public int getMinimumDifference(TreeNode root) {
        prev = -1;
        getMinDiff(root);
        return ans;
    }
    
    public void getMinDiff(TreeNode root) {
        if(root == null)
            return;
        getMinDiff(root.left);
        if(prev >= 0)
        ans = Math.min(ans, root.val - prev);
        prev = root.val;
        getMinDiff(root.right);
    }
}