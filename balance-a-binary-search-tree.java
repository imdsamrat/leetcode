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
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        if(root == null)
            return root;
        list = new ArrayList<>();
        inorder(root);
        return balancedBST(0, list.size() -1);
    }
    
    public TreeNode balancedBST(int left, int right) {
        if(left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode root = list.get(mid);
            root.left = balancedBST(left, mid - 1);
            root.right = balancedBST(mid + 1, right);
            return root;
        }
        return null;
    }
    
    
    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}