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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null)
            return Arrays.asList(0.0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size;
        double sum = 0.0;
        List<Double> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            size = q.size();
            sum = 0.0;
            for(int i = 0; i< size; i++) {
                TreeNode front = q.poll();
                if(front.left != null)
                    q.add(front.left);
                if(front.right != null)
                    q.add(front.right);
                sum += front.val;
            }
            ans.add(sum/size);
        }
        return ans;
    }
}