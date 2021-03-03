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
    public int ans;
    public int findTilt(TreeNode root) {
        ans = 0;
        findTiltUtil(root);
        return ans;
    }
    
     public int findTiltUtil(TreeNode root) {
        if(root == null)
            return 0;
        int lSum = findTiltUtil(root.left);
        int rSum = findTiltUtil(root.right);
        ans+= Math.abs(lSum - rSum);
        return lSum+rSum+root.val;
    }
}