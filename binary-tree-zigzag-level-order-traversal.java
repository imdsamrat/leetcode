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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isOrderLeft = true;
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> entry = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if(isOrderLeft) entry.addLast(temp.val);
                else entry.addFirst(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            isOrderLeft = !isOrderLeft;
            ans.add(entry);
        }
        return ans;
    }
}