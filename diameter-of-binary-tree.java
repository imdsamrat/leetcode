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
    class AugNode{
        int dia;
        int height;
        AugNode(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        AugNode ans = findDiameter(root);
        return ans.dia;
    }
    
    public AugNode findDiameter(TreeNode root) {
        if(root == null)
            return new AugNode(0, 0);
        AugNode left = findDiameter(root.left);
        AugNode right = findDiameter(root.right);
        
        int dia = left.height + right.height;
        dia = Math.max(dia, Math.max(left.dia, right.dia));
        return new AugNode(dia, Math.max(left.height, right.height) + 1);
    }
}