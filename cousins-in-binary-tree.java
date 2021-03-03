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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            int found = -1;
            int size = q.size();
            for(int i = 0; i< size; i++) {
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                    if(node.left.val == x || node.left.val == y){
                        if(found >= 0){
                            if(found != i)
                                return true;
                            return false;
                        }
                        found = i;
                    }
                }
                if(node.right != null) {
                    q.add(node.right);
                    if(node.right.val == x || node.right.val == y){
                        if(found >= 0){
                            if(found != i)
                                return true;
                            return false;
                        }
                        found = i;
                    }
                }
            }
        }
        return false;
    }
}