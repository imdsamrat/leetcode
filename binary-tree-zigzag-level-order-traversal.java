/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // add the root element with a delimiter to kick off the BFS loop
        q.add(root);
        q.add(null);
        LinkedList<Integer> levelList = new LinkedList<Integer>();
        boolean isOrderLeft = true;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp != null) {
                if (isOrderLeft)
                  levelList.addLast(temp.val);
                else
                  levelList.addFirst(temp.val);
                if (temp.left != null)
                  q.add(temp.left);
                if (temp.right != null)
                  q.add(temp.right);
            } else {
            // we finish the scan of one level
                ans.add(levelList);
                levelList = new LinkedList<Integer>();
                // prepare for the next level
                if (!q.isEmpty())
                  q.add(null);
                isOrderLeft = !isOrderLeft;
            }
        }
        return ans;
    }
}