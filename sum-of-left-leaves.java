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
    public int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        sumOfLeftLeavesUtil(root, false);
        return ans;
    }
    
    public void sumOfLeftLeavesUtil(TreeNode root, boolean isLeftChild) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            if(isLeftChild)
                ans+=root.val;
            return;
        }
        sumOfLeftLeavesUtil(root.left, true);
        sumOfLeftLeavesUtil(root.right, false);
    }
}