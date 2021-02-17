class AugNode{
    int dia;
    int height;
    public AugNode(int dia, int height){
        this.dia = dia;
        this.height = height;
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diaUtil(root).dia;
    }
    
    public AugNode diaUtil(TreeNode root){
        AugNode ret = new AugNode(0, 0);
        if(root == null)
            return ret;
        if(root.left == null && root.right == null){
            ret.height = 1;
            return ret;
        }

        AugNode left = diaUtil(root.left);
        AugNode right = diaUtil(root.right);
       
        ret.dia = Math.max(left.height + right.height, Math.max(left.dia, right.dia));
        ret.height = Math.max(left.height, right.height) + 1;
        return ret;
    }
}
