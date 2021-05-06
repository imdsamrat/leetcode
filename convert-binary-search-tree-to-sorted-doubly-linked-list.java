/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head = null, tail = null;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        treeToDoublyListUtil(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    
    public void treeToDoublyListUtil(Node root) {
        if(root == null)
            return;
        treeToDoublyListUtil(root.right);
        if(head != null)
            head.left = root;
        root.right = head;
        head = root;
        if(tail == null)
            tail = root;
        treeToDoublyListUtil(root.left);
    }
}