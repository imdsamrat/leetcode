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
    public int min, sMin, max;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        min = root.val;
        sMin = Integer.MAX_VALUE;
        max = root.val;
        inorder(root);
        if(sMin<=max)
            return sMin;
        return -1;
        
    }
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        max = Math.max(max, root.val);
        if(root.val < min) {
            sMin = min;
            min = root.val;
        } else if (root.val > min && root.val < sMin){
            sMin = root.val;
        }
        inorder(root.right);
    }
    
    
}