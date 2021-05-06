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
    List<Integer> data;
    int ans;
    public int sumNumbers(TreeNode root) {
        data = new ArrayList<>();
        ans = 0; 
        sumNumbersUtil(root, 0);
        return ans;
    }
    
    public void sumNumbersUtil(TreeNode root, int idx) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            if(idx == 0) {
                ans += root.val;
                return;
            }
            data.add(idx, 10*data.get(idx -1)+root.val);
            ans += data.get(idx);
        }
        if(idx == 0)
            data.add(idx, root.val); 
        else 
            data.add(idx, 10*data.get(idx - 1)+root.val);
        sumNumbersUtil(root.left, idx + 1);
        sumNumbersUtil(root.right, idx + 1);
    }
}