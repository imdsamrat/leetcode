class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		preOrderUtil(root, ans);
		return ans;
	}

	private void preOrderUtil(TreeNode root, List<Integer> ans) {
		if (root == null)
			return;
		ans.add(root.val);
		preOrderUtil(root.left, ans);
		preOrderUtil(root.right, ans);
	}

}
