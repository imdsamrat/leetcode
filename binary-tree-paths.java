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
    public List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    List<Integer> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        getAllPaths(root, 0);
        return ans;
    }
    
    public void getAllPaths(TreeNode root, int index) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            if(index<path.size())
                path.set(index, root.val);
            else 
                path.add(root.val);
            sb.setLength(0);
            for(int i = 0; i<index; i++){
                sb.append(path.get(i) + "->");
            }
            sb.append(path.get(index));
            ans.add(sb.toString());
            return;
        }
        if(index<path.size())
                path.set(index, root.val);
        else 
            path.add(root.val);
        getAllPaths(root.left, index + 1);
        getAllPaths(root.right, index + 1);
        
    }
}