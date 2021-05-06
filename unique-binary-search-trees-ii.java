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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();
        if( l<=r ) {
            for(int i = l; i <= r; i++) {
                List<TreeNode> left = generateTrees(l, i - 1);
                List<TreeNode> right = generateTrees(i + 1, r);
                if(left.size() == 0 && right.size() == 0) {
                    ans.add(new TreeNode(i));
                } else if(left.size() == 0) {
                    for(int p = 0; p < right.size(); p++) {
                        TreeNode root = new TreeNode(i);
                        root.right = right.get(p);
                        ans.add(root);
                    }
                }else if(right.size() == 0) {
                    for(int p = 0; p < left.size(); p++) {
                        TreeNode root = new TreeNode(i);
                        root.left = left.get(p);
                        ans.add(root);
                    }
                } else {
                    for(int j = 0; j < left.size(); j++) {
                        for(int k = 0; k < right.size(); k++) {
                            TreeNode root = new TreeNode(i);
                            root.left = left.get(j);
                            root.right = right.get(k);
                            ans.add(root);
                        }
                    }
                }
            }
        }
        return ans;
    }
}