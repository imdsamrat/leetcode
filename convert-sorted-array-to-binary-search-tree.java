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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }
    
    public TreeNode bst(int[] arr, int low, int high) {
        if(low<high){
            int mid = low + (high - low) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = bst(arr, low, mid - 1);
            node.right = bst(arr, mid + 1, high);
            return node;
        }
        if(low == high)
            return new TreeNode(arr[low]);
        return null;
    }
}