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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0)
            return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<>();
        TreeNode root = new TreeNode(0);
            
        if(n == 1) {
            ans.add(root);
            return ans;
        }    
            
        for(int i = 1; i <= n - 2; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-(i+1));
            for(int l = 0; l < left.size(); l++) {
                for(int r = 0; r < right.size(); r++) {
                    root = new TreeNode(0);
                    root.left = left.get(l);
                    root.right = right.get(r);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
    
}