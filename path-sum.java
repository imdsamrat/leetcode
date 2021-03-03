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
    public static int sum = 0;
    public boolean hasPathSum(TreeNode root, int tSum) {
        sum = 0;
        return hasPathSumUtil(root, tSum);
    }
    
    public boolean hasPathSumUtil(TreeNode root, int tSum) {
        if(root == null)
            return false;
        sum += root.val;
        if(root.left == null && root.right == null) {
            if(sum == tSum)
                return true;
            sum -= root.val;
            return false;
        }
        boolean lS = hasPathSumUtil(root.left, tSum);
        boolean rS = hasPathSumUtil(root.right, tSum);
        sum -= root.val;
        return lS || rS;
    }
}