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
    public TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        lowestCommonAncestorUtil(root, p, q);
        return lca;
        
    }
    
    public boolean lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
        boolean l = lowestCommonAncestorUtil(root.left, p, q);
        boolean r = lowestCommonAncestorUtil(root.right, p, q);
        if(l && r || ((l || r) && (root == p || root == q))){
            lca = root;
            return true;
        }
        if(l || r || root == p || root == q)
            return true;
        return false;
    }
}


class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        findLCA(root, p, q);
        return lca;
    }
    
    public boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        if(left && right && lca == null)
            lca = root;
        if((left || right) && (root == p || root == q)){
            lca = root;
        }
        if(root == p || root == q){
            return true;
        }
        return left || right;
    }
}