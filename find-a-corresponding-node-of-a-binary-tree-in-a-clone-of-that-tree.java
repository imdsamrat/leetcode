/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution using level order traversal, taking 8ms due to adding and removing node from queue.

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)
            return null;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>(); 
        q1.add(original);
        q2.add(cloned);
        while(!q1.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1 == target)
                return node2;
            if(node1.left != null) {
                q1.add(node1.left);
                q2.add(node2.left);
            }
            if(node1.right != null) {
                q1.add(node1.right);
                q2.add(node2.right);
            }
        }
        return null;
    }
}

// Solution(Fast 1ms) no adding and removing from queue so faster one.

class Solution {
public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if(res != null)
            return res;
        return getTargetCopy(original.right, cloned.right, target);
    }
}