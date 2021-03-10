public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> boundary = new ArrayList<>();
    if (root == null) return boundary;
    boundary.add(root.val);
    collectLeftBoundary(root.left, boundary);
    collectLeaves(root, boundary);
    collectRightBoundary(root.right, boundary);
    return boundary;
}

private void collectLeftBoundary(TreeNode node, List<Integer> boundary) {
    if (node == null || isLeaf(node)) return;
    boundary.add(node.val);
    collectLeftBoundary(node.left != null ? node.left : node.right, boundary);
}

private void collectRightBoundary(TreeNode node, List<Integer> boundary) {
    if (node == null || isLeaf(node)) return;
    collectRightBoundary(node.right != null ? node.right : node.left, boundary);
    boundary.add(node.val);
}

private void collectLeaves(TreeNode node, List<Integer> boundary) {
    if (node == null) return;
    if (isLeaf(node)) {
        boundary.add(node.val);
    } else {
        collectLeaves(node.left, boundary);
        collectLeaves(node.right, boundary);
    }
}

private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
}