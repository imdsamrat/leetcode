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
    String ans = "{"; // bigger than 'z' i.e. 123 (> 'z' ascii)
    List<Integer> data;
    public String smallestFromLeaf(TreeNode root) {
        data = new ArrayList<>();
        smallestFromLeafUtil(root, 0);
        return ans;
    }
    
    public void smallestFromLeafUtil(TreeNode root, int idx) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            data.add(idx, root.val);
            StringBuilder sb = new StringBuilder();
            for(int i = idx; i >= 0; i--) {
                sb.append((char)('a' + data.get(i)));
            }
            String lans = sb.toString();
            ans = ans.compareTo(lans) <= 0 ? ans : lans;
            return;
        }
        data.add(idx, root.val);
        smallestFromLeafUtil(root.left, idx+1);
        smallestFromLeafUtil(root.right, idx+1);
    }
    
}